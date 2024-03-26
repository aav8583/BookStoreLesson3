package com.example.bookstore.mapper;

import com.example.bookstore.entity.Book;
import com.example.bookstore.model.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface BookMapper {

    @Mapping(target = "authors", ignore = true)
    BookResponse bookToResponse(Book book);

    @Mapping(target = "authors", source = "authors")
    List<BookResponse> booksToBookResponse(List<Book> books);

    default Page<BookResponse> pageBooksToPageBookResponse(Page<Book> bookPage) {
        return bookPage.map(this::bookToResponse);
    }

}
