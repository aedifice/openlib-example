package com.example.books.service.openlib;

import com.example.books.common.Constants;
import com.example.books.model.openlib.SearchRecord;
import com.example.books.model.openlib.SearchRecordDoc;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class OpenLibraryServiceImpl implements OpenLibraryService {

    final private ObjectMapper objectMapper;

    public OpenLibraryServiceImpl() {
        this.objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public Optional<SearchRecordDoc> searchByIsbn(String isbn) {
        String searchUrl = Constants.OPENLIB_BASE_URL + "/search.json?isbn=" + isbn;
        HttpGet request = new HttpGet(searchUrl);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            CloseableHttpResponse response = httpClient.execute(request);

            SearchRecord searchRecord = objectMapper.readValue(EntityUtils.toString(response.getEntity()),
                    SearchRecord.class);
            SearchRecordDoc bookRecord = searchRecord.getDocs()[0];

            response.close();
            return Optional.of(bookRecord);
        } catch (IOException | ParseException e) {
            System.out.println("Error retrieving search results: " + e.toString());
        }

        return Optional.empty();
    }
}
