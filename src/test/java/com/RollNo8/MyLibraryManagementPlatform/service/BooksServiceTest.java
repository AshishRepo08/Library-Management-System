package com.RollNo8.MyLibraryManagementPlatform.service;

import com.RollNo8.MyLibraryManagementPlatform.entity.Author;
import com.RollNo8.MyLibraryManagementPlatform.entity.Book;
import com.RollNo8.MyLibraryManagementPlatform.entity.Genre;
import com.RollNo8.MyLibraryManagementPlatform.repository.BooksRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class BooksServiceTest {
    @Autowired
    BooksRepo booksRepo;

    @Autowired
    BooksService booksService;

    @Autowired
    DataSource dataSource;


    @Test
    void checkDb() throws Exception {
        System.out.println(dataSource.getConnection().getMetaData().getURL());
    }

    @Test
    public void createNewBookTest() {
        Book newBook = new Book("Normal People","Page Turner Book", Genre.Fiction,2015,new Author("Sally Ronney","Ireland"));
        booksService.createNewBook(newBook);
        Optional<Book> bookFromRepo = booksRepo.findById(newBook.getBook_id());

        assertEquals(newBook.getTitle(),bookFromRepo.get().getTitle(),"Title of new Book created and book fetched from repo don't match.");
    }

    @Test
    public void getBookByIdTest() {
        Book newBook = new Book("Normal People","Page Turner Book", Genre.Fiction,2015,new Author("Sally Ronney","Ireland"));
        booksService.createNewBook(newBook);
        Book bookFromRepo = booksService.getBookById(2);
        assertEquals(newBook.getTitle(),bookFromRepo.getTitle(),"Title of Book searched should match to the book");
    }

    @Test
    public void deleteBookTest() {
        Optional<Book> deleteBook = booksRepo.findById(1L);
        assertTrue(deleteBook.isPresent(),"Book should be present");

        booksService.deleteBook(1);

        deleteBook = booksRepo.findById(1L);
        assertFalse(deleteBook.isPresent(),"Book should be deleted");
    }

    @Test
    public void getAllBooksTest() {
        Book book1 = new Book(
                "Normal People",
                "Page Turner Book",
                Genre.Fiction,
                2015,
                new Author("Sally Rooney","Ireland")
        );

        booksService.createNewBook(book1);

        List<Book> allBooks = booksService.getAllBooks();

        assertEquals(2, allBooks.size());
    }

}