package com.RollNo8.MyLibraryManagementPlatform;

import jakarta.persistence.Cacheable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class MyLibraryManagementPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyLibraryManagementPlatformApplication.class, args);
		System.out.println("Welcome to The Library Management Platform");
	}
}
