package com.example.bookstore.mapper;

import com.example.bookstore.entity.Author;
import com.example.bookstore.model.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface AuthorMapper {

    @Mapping(target = "books", ignore = true)
    AuthorResponse authorToAuthorResponse(Author author);

    @Mapping(target = "books", source = "books")
    List<AuthorResponse> authorsToAuthorResponse(List<Author> books);
}
