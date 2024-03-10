package org.example.service.author;

import lombok.RequiredArgsConstructor;
import org.example.model.Author;
import org.example.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    @Override
    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author createAuthor(Author author) {
        return this.authorRepository.save(author);
    }
}
