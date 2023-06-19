package com.example.books.controller;

import com.example.books.model.Book;
import com.example.books.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    final private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/isbn")
    public Book getBookByIsbn(@RequestParam String isbn) {
        return bookService.getBookByIsbn(isbn);
    }
}
