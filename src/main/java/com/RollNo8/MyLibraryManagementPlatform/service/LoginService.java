package com.RollNo8.MyLibraryManagementPlatform.service;

import com.RollNo8.MyLibraryManagementPlatform.entity.LibraryUser;
import com.RollNo8.MyLibraryManagementPlatform.serviceJWT.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    public String verify(LibraryUser libraryUser){
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(libraryUser.getUsername(),libraryUser.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(libraryUser.getUsername());
        }
        return "Fail";
    }
}
