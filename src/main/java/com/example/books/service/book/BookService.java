package com.example.books.service.book;

import com.example.books.model.Book;

public interface BookService {

    Book getBookByIsbn(String isbn);

}
