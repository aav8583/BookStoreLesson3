package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Author;
import com.example.bookstore.model.AuthorResponse;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.specification.AuthorSpecification;
import com.example.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author findOrCreateAuthor(String firstname, String lastname, String secondName) {
        return authorRepository
                .findAll()
                .stream()
                .filter(a -> a.getFirstname().equals(firstname) &&
                        a.getLastname().equals(lastname) &&
                        a.getSecondName().equals(secondName))
                .findFirst()
                .orElseGet(() -> authorRepository.save(new Author(firstname, lastname, secondName, new HashSet<>())));
    }

    @Override
    public List<Author> findAuthors(String firstname, String secondName, String lastname) {
        return authorRepository.findAll(AuthorSpecification.findByCriteria(firstname, secondName, lastname));
    }

}
