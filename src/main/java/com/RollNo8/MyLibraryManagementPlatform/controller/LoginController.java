package com.RollNo8.MyLibraryManagementPlatform.controller;

import com.RollNo8.MyLibraryManagementPlatform.entity.LibraryUser;
import com.RollNo8.MyLibraryManagementPlatform.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody LibraryUser libraryUser){
        System.out.println(libraryUser);
        return loginService.verify(libraryUser);
    }

}
