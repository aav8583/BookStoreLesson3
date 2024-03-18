package com.example.bookstore.service;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;

import java.util.List;
import java.util.Set;

public interface BookService {

    Book createBook(String title, Set<Author> authors);
    List<Book> fetchAll();

}
