package com.RollNo8.MyLibraryManagementPlatform.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor()
public class Book {

    public Book(String title, String description, Genre genre, Integer publishmentYear, Author author) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.publishmentYear = publishmentYear;
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long book_id;

    @Column(nullable = false,length = 50)
    private String title;

    @Column(nullable = false,length = 100)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(nullable = false)
    private Integer publishmentYear;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;

    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime modified=LocalDateTime.now();
}
