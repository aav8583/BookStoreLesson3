package com.example.bookstore.model;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class AuthorResponse {

    private UUID id;
    private String firstname;
    private String lastname;
    private List<BookResponse> books;
}
