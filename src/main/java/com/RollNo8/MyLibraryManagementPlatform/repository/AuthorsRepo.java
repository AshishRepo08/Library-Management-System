package com.RollNo8.MyLibraryManagementPlatform.repository;

import com.RollNo8.MyLibraryManagementPlatform.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepo extends JpaRepository<Author,Long> {
}
