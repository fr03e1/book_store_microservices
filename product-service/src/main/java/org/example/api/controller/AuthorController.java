package org.example.api.controller;

import jakarta.validation.Valid;
import org.example.constant.ApiConstant;
import org.example.api.dto.author.AuthorRequest;
import org.example.api.dto.author.AuthorResponse;
import org.example.api.mapper.author.AuthorDtoMapper;
import org.example.model.Author;
import org.example.service.author.AuthorService;
import org.example.service.producer.KafkaProducerImpl;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ApiConstant.API_AUTHORS)
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorDtoMapper authorMapper;
    private final KafkaProducerImpl kafkaProducer;

    public AuthorController(AuthorService authorService, KafkaProducerImpl kafkaProducer) {
        this.authorService = authorService;
        this.kafkaProducer = kafkaProducer;
        this.authorMapper = Mappers.getMapper(AuthorDtoMapper.class);
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAllAuthors() {
        final Optional<List<Author>> authorsOptional = Optional.of(authorService.getAllAuthors());
        return authorsOptional.map(authors -> {
            List<AuthorResponse> authorResponses = authors.stream()
                    .map(this.authorMapper::authorToAuthorResponse)
                    .collect(Collectors.toList());
            return ResponseEntity.ok().body(authorResponses);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AuthorResponse createAuthor(@Valid @RequestBody AuthorRequest authorRequest) {
        final Author author = this.authorMapper.map(authorRequest);
        final Author createdAuthor = this.authorService.createAuthor(author);
        this.kafkaProducer.sendMessage("Author created");
        return this.authorMapper.authorToAuthorResponse(createdAuthor);
    }
}
