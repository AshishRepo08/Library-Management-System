package com.RollNo8.MyLibraryManagementPlatform.dtos;

import com.RollNo8.MyLibraryManagementPlatform.entity.Author;
import com.RollNo8.MyLibraryManagementPlatform.entity.Genre;
import lombok.Data;


public record BookDto(
        String title,
        String description,
        Genre genre,
        Integer publishmentYear,
        AuthorDto authorDto) {
}
