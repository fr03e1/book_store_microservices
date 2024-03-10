package org.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.constant.ApiConstant;
import org.example.model.Book;
import org.example.service.book.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstant.API_BOOKS)
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> products() {
        return this.bookService.getAllBooks();
    }

    @PostMapping
    public Book saveProduct(@RequestBody Book book) {
        return this.bookService.createBook(book);
    }
}
