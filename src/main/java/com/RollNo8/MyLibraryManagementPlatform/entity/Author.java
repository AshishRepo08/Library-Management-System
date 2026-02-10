package com.RollNo8.MyLibraryManagementPlatform.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Author {

    public Author(String authorName, String nationality) {
        this.authorName = authorName;
        this.nationality = nationality;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorId;

    @Column(name = "authorName",nullable = false,length = 30)
    private String authorName;

    @Column(name = "nationality",nullable = false,length = 30)
    private String nationality;

    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;

    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime modified=LocalDateTime.now();

//    @Override
//    public String toString() {
//        return "Author{" +
//                "authorId=" + authorId +
//                ", authorName='" + authorName + '\'' +
//                ", nationality='" + nationality + '\'' +
//                ", book=" + book +
//                ", created=" + created +
//                ", modified=" + modified +
//                '}';
//    }
}
