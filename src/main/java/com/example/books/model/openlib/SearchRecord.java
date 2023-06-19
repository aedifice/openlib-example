package com.example.books.model.openlib;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchRecord {

    private int numFound;
    private SearchRecordDoc[] docs;

}
