package com.example.LibraryManagementApplication.Book;

import com.example.LibraryManagementApplication.BookAuthor.BookAuthor;
import com.example.LibraryManagementApplication.Publisher.Publisher;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int bookId;

    @Column(unique = true)
    public String ISBN;

    public  String title;
    public String genre;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public int price;
    public LocalDateTime publishedDate;
    public  LocalDateTime createdAt;

    @Enumerated(EnumType.ORDINAL)
    public BookStatus status;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BookAuthor> bookAuthors = new HashSet<>();

}
