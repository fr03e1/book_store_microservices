package org.example.api.mapper.author;

import org.example.api.dto.author.AuthorRequest;
import org.example.api.dto.author.AuthorResponse;
import org.example.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface AuthorDtoMapper {
    Author map(AuthorRequest authorRequest);
    List<AuthorRequest> map(List<Author> authors);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    AuthorResponse authorToAuthorResponse(Author author);
}
