package com.example.bookstore.api;

import com.example.bookstore.model.BookRequest;
import com.example.bookstore.model.BookResponse;
import com.example.bookstore.service.facade.BookAuthorFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {

    private final BookAuthorFacade bookAuthorFacade;

    @PostMapping
    public BookResponse createBook(@RequestBody BookRequest bookRequest) {
        return bookAuthorFacade.createBookWithAuthor(bookRequest);
    }

    @GetMapping
    public List<BookResponse> fetchAll() {
        return bookAuthorFacade.fetchAll();
    }
}
