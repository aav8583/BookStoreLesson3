package com.example.bookstore.api;

import com.example.bookstore.model.AuthorResponse;
import com.example.bookstore.service.facade.BookAuthorFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("authors")
@RequiredArgsConstructor
public class AuthorController {

    private final BookAuthorFacade bookAuthorFacade;

    @GetMapping
    public List<AuthorResponse> fetchAuthors(@RequestParam(name = "firstname") String firstname,
                                             @RequestParam(name = "secondName") String secondName,
                                             @RequestParam(name = "lastname") String lastname) {
        return bookAuthorFacade.findAuthors(firstname, secondName, lastname);
    }

}
