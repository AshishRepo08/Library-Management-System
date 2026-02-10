package com.RollNo8.MyLibraryManagementPlatform.mappers;

import com.RollNo8.MyLibraryManagementPlatform.dtos.AuthorDto;
import com.RollNo8.MyLibraryManagementPlatform.entity.Author;
import org.springframework.stereotype.Component;


public interface AuthorMapper {

    Author fromDto(AuthorDto authorDto);

    AuthorDto toDto(Author author);
}
