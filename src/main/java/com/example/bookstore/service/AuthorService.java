package com.example.bookstore.service;

import com.example.bookstore.entity.Author;

import java.util.List;

public interface AuthorService {

    Author findOrCreateAuthor(String firstname, String lastname, String secondName);
    List<Author> findAuthors(String firstname, String secondName, String lastname);
}
