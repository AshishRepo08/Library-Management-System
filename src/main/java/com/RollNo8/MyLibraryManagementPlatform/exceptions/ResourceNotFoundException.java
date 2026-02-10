package com.RollNo8.MyLibraryManagementPlatform.exceptions;

import org.springframework.context.annotation.Configuration;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
