package com.example.books.service.openlib;

import com.example.books.model.openlib.SearchRecordDoc;

import java.util.Optional;

public interface OpenLibraryService {

    Optional<SearchRecordDoc> searchByIsbn(String isbn);

}
