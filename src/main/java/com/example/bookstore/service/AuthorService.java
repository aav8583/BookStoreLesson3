package com.example.bookstore.service;

import com.example.bookstore.entity.Author;

public interface AuthorService {

    Author findOrCreateAuthor(String firstname, String lastname, String secondName);

}
