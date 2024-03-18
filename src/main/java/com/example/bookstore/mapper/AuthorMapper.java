package com.example.bookstore.mapper;

import com.example.bookstore.entity.Author;
import com.example.bookstore.model.AuthorResponse;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorMapper {

    AuthorResponse authorToAuthorResponse(Author author);
}
