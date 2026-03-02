package com.RollNo8.MyLibraryManagementPlatform.advices;

import com.RollNo8.MyLibraryManagementPlatform.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex){
        System.out.println("Resource Not Found Exception In Print");
        return new ResponseEntity<>("Global Exception Handler : ResourceNotFoundException Encountered. No Book Present With This Id.",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex){
        System.out.println("Runtime Exception : Print Statement");
        return ResponseEntity.internalServerError().build();
    }

}
