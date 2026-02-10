package com.RollNo8.MyLibraryManagementPlatform.mappers;

import com.RollNo8.MyLibraryManagementPlatform.dtos.BookDto;
import com.RollNo8.MyLibraryManagementPlatform.entity.Book;

public interface BookMapper {

    Book fromDto(BookDto bookDto);

    BookDto toDto(Book book);
}
