package com.RollNo8.MyLibraryManagementPlatform.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

    @Before("execution(* com.RollNo8.MyLibraryManagementPlatform.controller.BooksController.deleteBook(..))")
    public void bookDeleteExecuted(){
        System.out.println("AOP --- Book Deletion Log from the Aspect Class");
    }
}
