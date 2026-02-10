package com.RollNo8.MyLibraryManagementPlatform.controller;

import com.RollNo8.MyLibraryManagementPlatform.dtos.AuthorDto;
import com.RollNo8.MyLibraryManagementPlatform.entity.Author;
import com.RollNo8.MyLibraryManagementPlatform.entity.Book;
import com.RollNo8.MyLibraryManagementPlatform.mappers.impl.AuthorMapperImpl;
import com.RollNo8.MyLibraryManagementPlatform.service.AuthorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v2/authors")
@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorsService authorsService;
    private final AuthorMapperImpl authorMapper;

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors(){
        List<AuthorDto> authorDtoList = authorsService.getAllAuthors()
                .stream()
                .map(authorMapper::toDto)
                .toList();

        return new ResponseEntity<>(authorDtoList,HttpStatus.OK);
    }

    @GetMapping("author/{author_id}")
    public ResponseEntity<?> getAuthorById(@PathVariable long author_id){
        return new ResponseEntity<>(authorMapper.toDto(authorsService.getAuthorById(author_id)),HttpStatus.FOUND);
    }

    @PutMapping("author/{author_id}")
    public ResponseEntity<?> updateAuthor(@PathVariable long author_id,@RequestBody AuthorDto updatedAuthorDto){

        //System.out.println("Input author: "+updatedAuthor);
        //Input author: Author{authorId=0, authorName='Seneca Romano', nationality='Roma Victor - Strength & Honor', book=null, created=null, modified=2026-01-18T22:38:29.901219900}

        try {
            authorsService.updateAuthor(author_id,authorMapper.fromDto(updatedAuthorDto));
            return new ResponseEntity<>(authorsService.getAuthorById(author_id),HttpStatus.ACCEPTED);
        } catch (IllegalArgumentException Ix) {
            return new ResponseEntity<>("Check Your Input Values For Author",HttpStatus.BAD_REQUEST);
        }
    }


}
