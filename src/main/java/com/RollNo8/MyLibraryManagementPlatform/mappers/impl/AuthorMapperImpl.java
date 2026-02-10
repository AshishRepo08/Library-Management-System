package com.RollNo8.MyLibraryManagementPlatform.mappers.impl;

import com.RollNo8.MyLibraryManagementPlatform.dtos.AuthorDto;
import com.RollNo8.MyLibraryManagementPlatform.entity.Author;
import com.RollNo8.MyLibraryManagementPlatform.mappers.AuthorMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements AuthorMapper {
    @Override
    public Author fromDto(AuthorDto authorDto) {
        return new Author(
                authorDto.authorName(),
                authorDto.nationality()
        );
    }

    @Override
    public AuthorDto toDto(Author author) {
        return new AuthorDto(author.getAuthorName(), author.getNationality());
    }
}
