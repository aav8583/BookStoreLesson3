package com.example.bookstore.model;

import lombok.Data;

@Data
public class BookRequest {

    private String title;
    private String authorFirstName;
    private String authorSecondName;
    private String authorLastName;

}
