package com.example.LibraryManagementApplication.Borrowing;

import com.example.LibraryManagementApplication.Books.Book;
import com.example.LibraryManagementApplication.Members.Member;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  int borrowId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    public Member member;

    @ManyToOne
    @JoinColumn(name = "book_id")
    public Book book;

    public LocalDateTime borrowDate;
    public LocalDateTime returnDate;


}
