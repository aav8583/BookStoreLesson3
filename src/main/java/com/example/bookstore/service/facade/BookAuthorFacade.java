package com.example.bookstore.service.facade;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.mapper.AuthorMapper;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.model.AuthorResponse;
import com.example.bookstore.model.BookRequest;
import com.example.bookstore.model.BookResponse;
import com.example.bookstore.service.AuthorService;
import com.example.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookAuthorFacade {

    private final BookService bookService;
    private final AuthorService authorService;
    private final BookMapper bookMapper;
    private final AuthorMapper authorMapper;

    public BookResponse createBookWithAuthor(BookRequest bookRequest) {
        var author = authorService.findOrCreateAuthor(bookRequest.getAuthorFirstName(),
                bookRequest.getAuthorLastName(), bookRequest.getAuthorLastName());
        var book = bookService.createBook(bookRequest.getTitle(),
                bookRequest.getYear(),
                bookRequest.getDescription(),
                new HashSet<>(Collections.singletonList(author)));
        author.getBooks().add(book);
        return bookMapper.bookToResponse(book);
    }

    public List<BookResponse> fetchAll() {
        List<BookResponse> returnedList = new ArrayList<>();
        bookService.fetchAll().forEach(book -> {
            var bookResponse = bookMapper.bookToResponse(book);
            returnedList.add(bookResponse);
        });
        return returnedList;
    }

    public Page<BookResponse> fetchBookAfterYear(Integer year, Pageable pageable) {
        return bookMapper.pageBooksToPageBookResponse(bookService.fetchBookAfterYear(year, pageable));
    }

    public List<AuthorResponse> findAuthors(String firstname, String secondName, String lastname){
       return authorMapper.authorsToAuthorResponse(authorService.findAuthors(firstname, secondName, lastname));
    }
}
