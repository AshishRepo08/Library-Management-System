package com.RollNo8.MyLibraryManagementPlatform.repository;

import com.RollNo8.MyLibraryManagementPlatform.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepo extends JpaRepository<Book,Long> {

}
