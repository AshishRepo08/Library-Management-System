package com.RollNo8.MyLibraryManagementPlatform.service;

import com.RollNo8.MyLibraryManagementPlatform.entity.LibraryUser;
import com.RollNo8.MyLibraryManagementPlatform.repository.LibraryUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryUsersService {

    private final LibraryUserRepo libraryUserRepo;

    public List<LibraryUser> getAllUsers() {
        return libraryUserRepo.findAll();
    }






}
