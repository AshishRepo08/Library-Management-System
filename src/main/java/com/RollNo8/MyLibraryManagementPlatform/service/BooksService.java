package com.RollNo8.MyLibraryManagementPlatform.service;

import com.RollNo8.MyLibraryManagementPlatform.entity.Book;
import com.RollNo8.MyLibraryManagementPlatform.exceptions.ResourceNotFoundException;
import com.RollNo8.MyLibraryManagementPlatform.repository.BooksRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepo booksRepo;

    Logger logger = LoggerFactory.getLogger(BooksService.class);

    public List<Book> getAllBooks() {

//        logger.error("ERROR LOG BY AK");
//        logger.warn("WARN LOG BY AK");
//        logger.info("INFO LOG BY AK");
//        logger.debug("DEBUG LOG BY AK ");
//        logger.trace("TRACE LOG BY AK");

        logger.info("Fetched All Books");
        return booksRepo.findAll();
    }

    public Book getBookById(long bookId) {
        logger.info("Fetching book with bookId: {}",bookId);
        return booksRepo.findById(bookId)
                .orElseThrow(()-> new ResourceNotFoundException("No Book found with the author id: "+bookId));
    }

    public Book createNewBook(Book newBook) {
        System.out.println("In Service Method - New Book Created");
        return booksRepo.save(newBook);
    }

    @Transactional
    public void updateBook(Book updatedBook,Long book_id) {
        Book existingBook = getBookById(book_id);

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setDescription(updatedBook.getDescription());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setPublishmentYear(updatedBook.getPublishmentYear());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setModified(updatedBook.getModified());

        booksRepo.save(existingBook);

        //Flow of how it works
        //Find the book
        //Create the author
        //Update the attribute of the book including new author
        //Delete old author
    }

    public void deleteBook(long bookId) {

        booksRepo.deleteById(bookId);
    }
}
