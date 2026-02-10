package com.RollNo8.MyLibraryManagementPlatform.entity;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String name;
    private String email;
    private String category;
    private String username;
    private String password;

    public LibraryUser toLibraryUser(PasswordEncoder passwordEncoder){
        System.out.println("In Registration Form's - toLibraryUser Method");
        return new LibraryUser(
                name,
                email,
                category,
                username,
                passwordEncoder.encode(password)
        );
    }

    @Override
    public String toString() {
        return "RegistrationForm{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", category='" + category + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
