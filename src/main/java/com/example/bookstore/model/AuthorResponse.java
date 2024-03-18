package com.example.bookstore.model;

import lombok.Data;

import java.util.UUID;

@Data
public class AuthorResponse {

    private UUID id;
    private String firstname;
    private String lastname;
}
