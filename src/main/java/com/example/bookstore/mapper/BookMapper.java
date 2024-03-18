package com.example.bookstore.mapper;

import com.example.bookstore.entity.Book;
import com.example.bookstore.model.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper {

    @Mapping(target = "authors", source = "authors")
    BookResponse bookToResponse(Book book);

}
