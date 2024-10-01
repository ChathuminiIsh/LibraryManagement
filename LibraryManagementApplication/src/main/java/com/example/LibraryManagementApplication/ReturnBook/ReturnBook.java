package com.example.LibraryManagementApplication.ReturnBook;

import com.example.LibraryManagementApplication.Books.Book;
import com.example.LibraryManagementApplication.Members.Member;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@Entity
public class ReturnBook {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int returnId;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    private LocalDate borrowDate;
    private LocalDate returnDate;
    private LocalDate actualReturnDate;

    @Transient
    private long fine;



}

