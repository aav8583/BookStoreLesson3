package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book createBook(String title, Set<Author> authors) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthors(authors);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> fetchAll() {
       return bookRepository.findAll();
    }
}
