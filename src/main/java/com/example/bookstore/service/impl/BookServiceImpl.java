package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book createBook(String title, Integer year, String description, Set<Author> authors) {
        Book book = new Book()
                .setTitle(title)
                .setYear(year)
                .setDescription(description)
            .setAuthors(authors);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> fetchAll() {
       return bookRepository.findAll();
    }

    @Override
    public Page<Book> fetchBookAfterYear(Integer year, Pageable pageable) {
        return bookRepository.findAllBooksAfterYear(year, pageable);
    }
}
