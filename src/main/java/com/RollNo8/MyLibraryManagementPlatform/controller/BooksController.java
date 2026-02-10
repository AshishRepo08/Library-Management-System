package com.RollNo8.MyLibraryManagementPlatform.controller;

import com.RollNo8.MyLibraryManagementPlatform.dtos.BookDto;
import com.RollNo8.MyLibraryManagementPlatform.entity.Book;
import com.RollNo8.MyLibraryManagementPlatform.mappers.impl.BookMapperImpl;
import com.RollNo8.MyLibraryManagementPlatform.service.BooksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/v2/books")
@RestController
@RequiredArgsConstructor
@Tag(name = "Books Controller",description = "CRUD Operations Related To Books")
public class BooksController {

    private final BooksService booksService;

    private final BookMapperImpl bookMapper;

    //Get All Books
    @GetMapping()
    @Operation(summary = "Gets All Books",description = "Fetches all the books")
    public ResponseEntity<List<BookDto>> getAllBooksDto(){
        List<Book> books = booksService.getAllBooks();

        List<BookDto> bookDtoList = books
                .stream()
                .map(bookMapper::toDto)
                .toList();

        return new ResponseEntity<>(bookDtoList,HttpStatus.OK);
    }

    //Get Book By Id
    @GetMapping("book/{book_id}")
    public ResponseEntity<?> getBookById(@PathVariable long book_id){
        Book requestedBook = booksService.getBookById(book_id);
        return new ResponseEntity<>(bookMapper.toDto(requestedBook),HttpStatus.FOUND);
//        try {
//            Book requestedBook = booksService.getBookById(book_id);
//            return new ResponseEntity<>(bookMapper.toDto(requestedBook),HttpStatus.FOUND);
//        } catch (RuntimeException rx){
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("code","USER_NOT_FOUND");
//            headers.add("error","Resource Not Found");
//
//            return new ResponseEntity<>("No Book With This Id Found.Recheck the bookId",headers,HttpStatus.NOT_FOUND);
//        }
    }

    //Add A new Book
    @PostMapping()
    public ResponseEntity<BookDto> createNewBook(@RequestBody BookDto newBookDto){
        //System.out.println(newBookDto);
        Book createdBook = booksService.createNewBook(bookMapper.fromDto(newBookDto));
        return new ResponseEntity<>(bookMapper.toDto(createdBook),HttpStatus.CREATED);
        //return newBook;
    }

    //Update a Book
    @PutMapping("book/{book_id}")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto updatedBook,@PathVariable long book_id){
        booksService.updateBook(bookMapper.fromDto(updatedBook),book_id);
        return new ResponseEntity<>(bookMapper.toDto(booksService.getBookById(book_id)),HttpStatus.OK);
    }

    //Delete a Book
    @DeleteMapping("book/{book_id}")
    public void deleteBook(@PathVariable long book_id){
        booksService.deleteBook(book_id);
    }
}
