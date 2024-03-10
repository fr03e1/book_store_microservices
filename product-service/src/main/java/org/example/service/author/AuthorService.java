package org.example.service.author;

import org.example.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    Author createAuthor(Author author);
}
