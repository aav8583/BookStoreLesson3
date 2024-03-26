package com.example.bookstore.service;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface BookService {

    Book createBook(String title, Integer year, String description, Set<Author> authors);
    List<Book> fetchAll();
    Page<Book> fetchBookAfterYear(Integer year, Pageable pageable);

}
