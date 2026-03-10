package com.RollNo8.MyLibraryManagementPlatform.service;

import com.RollNo8.MyLibraryManagementPlatform.entity.Author;
import com.RollNo8.MyLibraryManagementPlatform.repository.AuthorsRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import javax.sql.DataSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class AuthorsServiceTest {

    @Autowired
    AuthorsRepo authorsRepo;

    @Autowired
    AuthorsService authorsService;

    @Autowired
    DataSource dataSource;

    @Test
    void checkDb() throws Exception{
        System.out.println(dataSource.getConnection().getMetaData().getURL());
    }

    @Test
    void getAuthorByIdTest() {
        Author newAuthor = new Author("Fredrik Backman","Swedish");
        authorsRepo.save(newAuthor);

        Author authorFromRepo = authorsService.getAuthorById(1);
        assertEquals(newAuthor.getAuthorName(),authorFromRepo.getAuthorName(),"Title of Book searched should match to the book");
    }

    @Test
    void getAllAuthorsTest() {
        Author newAuthor = new Author("John Williams","American");
        authorsRepo.save(newAuthor);

        List<Author> allAuthors = authorsService.getAllAuthors();
        assertEquals(2,allAuthors.size());
    }

}