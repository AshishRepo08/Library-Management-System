package com.RollNo8.MyLibraryManagementPlatform.controller;

import com.RollNo8.MyLibraryManagementPlatform.entity.LibraryUser;
import com.RollNo8.MyLibraryManagementPlatform.repository.LibraryUserRepo;
import com.RollNo8.MyLibraryManagementPlatform.service.LibraryUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v2/user")
@RestController
@RequiredArgsConstructor
public class LibraryUserController {

    private final LibraryUserRepo libraryUserRepo;
    private final LibraryUsersService libraryUsersService;

    @GetMapping
    public List<LibraryUser> getAllUser(){
        System.out.println(libraryUserRepo.findAll());
        return libraryUserRepo.findAll();
    }

    @PostMapping
    public LibraryUser addUser(LibraryUser libraryUser){
        System.out.println("In controller");
        System.out.println(libraryUser);
        return libraryUserRepo.save(libraryUser);
    }

    @GetMapping("/getAllUsers")
    public List<LibraryUser> getAllUsers(){
        return libraryUsersService.getAllUsers();
    }



}
