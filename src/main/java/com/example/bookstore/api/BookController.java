package com.example.bookstore.api;

import com.example.bookstore.model.BookRequest;
import com.example.bookstore.model.BookResponse;
import com.example.bookstore.service.facade.BookAuthorFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @PostMapping("modify")
    public BookResponse modifyBook(@RequestBody BookRequest bookRequest) {
        return bookAuthorFacade.createBookWithAuthor(bookRequest);
    }

    @GetMapping
    public List<BookResponse> fetchAll() {
        return bookAuthorFacade.fetchAll();
    }

    @GetMapping("list")
    public Page<BookResponse> fetchBooksAfterYear(@RequestParam(name = "year") Integer year,
                                                  Pageable pageable
    ) {
        return bookAuthorFacade.fetchBookAfterYear(year, pageable);
    }
}
