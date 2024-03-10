package org.example.service.book;

import org.example.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book createBook(Book book);
}
