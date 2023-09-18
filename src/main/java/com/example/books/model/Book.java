package com.example.books.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private String uuid;
    private String title;
    private String author;
    private String coverImg;
    private int pages;
    private String isbn;
    private String openLibLink;
    private String bookshopLink;
    private String worldCatLink;

}
