package com.example.books.model.openlib;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchRecordDoc {

    // fields based on return values of the Open Library search API
    private String key;
    private String title;
    private String[] author_name;
    private int cover_i;
    private int first_publish_year;
    private int number_of_pages_median;
    private String[] isbn;
    private int ebook_count_i;
    private String ebook_access;
    private boolean has_fulltext;
    private boolean public_scan_b;

}
