package com.RollNo8.MyLibraryManagementPlatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping()
@Controller
public class WelcomeController {

    @GetMapping
    public String welcomeMessage(){
        System.out.println("In Welcome Controller");
        //For Audit
        return "Welcome";
    }

    @GetMapping("/login")
    public String loginPage(){
        System.out.println("Login Page Loaded");
        return "Login";
    }
}
