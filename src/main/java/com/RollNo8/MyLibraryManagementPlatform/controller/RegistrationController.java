package com.RollNo8.MyLibraryManagementPlatform.controller;

import com.RollNo8.MyLibraryManagementPlatform.entity.RegistrationForm;
import com.RollNo8.MyLibraryManagementPlatform.repo.LibraryUserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private LibraryUserRepo libraryUserRepo;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(LibraryUserRepo libraryUserRepo, PasswordEncoder passwordEncoder){
        this.libraryUserRepo = libraryUserRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registration(){
        System.out.println("Registration Form Loaded");
        return "Registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm registrationForm){
        System.out.println("Registration Form Submitted");
        System.out.println("In registration Controller : "+registrationForm);
        libraryUserRepo.save(registrationForm.toLibraryUser(passwordEncoder));
        return "redirect:/login";
    }

}
