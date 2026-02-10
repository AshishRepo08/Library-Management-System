package com.RollNo8.MyLibraryManagementPlatform.mappers.impl;

import com.RollNo8.MyLibraryManagementPlatform.dtos.AuthorDto;
import com.RollNo8.MyLibraryManagementPlatform.dtos.BookDto;
import com.RollNo8.MyLibraryManagementPlatform.entity.Book;
import com.RollNo8.MyLibraryManagementPlatform.mappers.AuthorMapper;
import com.RollNo8.MyLibraryManagementPlatform.mappers.BookMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper {

    private final AuthorMapper authorMapper;

    public BookMapperImpl(AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }


    @Override
    public Book fromDto(BookDto bookDto) {
        return new Book(
                bookDto.title(),
                bookDto.description(),
                bookDto.genre(),
                bookDto.publishmentYear(),
                authorMapper.fromDto(bookDto.authorDto())
        );
    }

    @Override
    public BookDto toDto(Book book) {
        return new BookDto(
                book.getTitle(),
                book.getDescription(),
                book.getGenre(),
                book.getPublishmentYear(),
                authorMapper.toDto(book.getAuthor())
                );
    }
}
