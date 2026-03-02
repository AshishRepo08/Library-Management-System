package com.RollNo8.MyLibraryManagementPlatform;

import com.RollNo8.MyLibraryManagementPlatform.entity.Book;
import com.RollNo8.MyLibraryManagementPlatform.repository.BooksRepo;
import com.RollNo8.MyLibraryManagementPlatform.service.BooksService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest_SecondPart {

    @Mock
    BooksRepo booksRepo;

    @InjectMocks
    BooksService booksService;

    @Test
    void addProductShouldAddProductSuccessfully(){
        Book b1 = new Book();
        b1.setTitle("Books for Testing");

        Mockito.when(booksService.createNewBook(b1)).thenReturn(b1);

        Book addedBook = booksService.createNewBook(b1);

        Assertions.assertEquals(b1.getTitle(),addedBook.getTitle());
    }

    @Test
    public void dummuyTest2(){
        System.out.println("Dummy2 Test Executed");
    }

    @Test
    void myFirstTest(){
        System.out.println("My First Unit Test");
    }

    @BeforeAll
    public static void init(){
        System.out.println("Before All Annotation associated method");
    }

    @BeforeEach
    public void initEachTest(){
        System.out.println("Before Each Annotation associated method");
    }

    @Test
    public void dummuyTest(){
        System.out.println("Dummy Test Executed");
    }

    @AfterAll
    public static void afterAllExample(){
        System.out.println("After All Annotation associated method");
    }

    @AfterEach
    public void afterEachExample(){
        System.out.println("After Each Annotation associated method");
    }



}
