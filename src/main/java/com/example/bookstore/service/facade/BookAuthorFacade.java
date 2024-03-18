package com.example.bookstore.service.facade;

import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.model.BookRequest;
import com.example.bookstore.model.BookResponse;
import com.example.bookstore.service.AuthorService;
import com.example.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
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

    public BookResponse createBookWithAuthor(BookRequest bookRequest) {
        var author = authorService.findOrCreateAuthor(bookRequest.getAuthorFirstName(),
                bookRequest.getAuthorLastName(), bookRequest.getAuthorLastName());
        var book = bookService.createBook(bookRequest.getTitle(),
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

}
