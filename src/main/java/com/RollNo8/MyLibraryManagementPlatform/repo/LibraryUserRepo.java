package com.RollNo8.MyLibraryManagementPlatform.repo;

import com.RollNo8.MyLibraryManagementPlatform.entity.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryUserRepo extends JpaRepository<LibraryUser,Integer> {
    LibraryUser findByUsername(String username);
}
