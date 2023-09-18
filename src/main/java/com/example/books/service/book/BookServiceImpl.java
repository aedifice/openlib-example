package com.example.books.service.book;

import com.example.books.common.Constants;
import com.example.books.model.Book;
import com.example.books.model.openlib.SearchRecordDoc;
import com.example.books.service.openlib.OpenLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    final private OpenLibraryService openLibraryService;

    @Autowired
    public BookServiceImpl(OpenLibraryService openLibraryService) {
        this.openLibraryService = openLibraryService;
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        Book book = new Book();
        book.setIsbn(isbn);

        // retrieve basic information about the book from Open Library
        Optional<SearchRecordDoc> optionalResult = openLibraryService.searchByIsbn(isbn);
        if (optionalResult.isPresent()) {
            SearchRecordDoc record = optionalResult.get();

            // remove path segment from key to reuse as an ID
            book.setUuid(record.getKey().replace("/works/", ""));

            book.setTitle(record.getTitle());
            book.setAuthor(record.getAuthor_name()[0]);
            book.setPages(record.getNumber_of_pages_median());

            // reformat cover image and Open Library record as URLs
            book.setCoverImg(Constants.OPENLIB_COVER_FORMAT.formatted(record.getCover_i()));
            book.setOpenLibLink(Constants.OPENLIB_BASE_URL + record.getKey());
        } else {
            book.setTitle("Not Found");
            book.setAuthor("Not Found");
            book.setOpenLibLink(Constants.OPENLIB_BASE_URL + "/search?isbn=" + isbn);
        }

        // provide links to search results from other services
        book.setBookshopLink(Constants.BOOKSHOP_SEARCH_URL + isbn);
        book.setWorldCatLink(Constants.WORLDCAT_SEARCH_URL + isbn);

        return book;
    }
}
