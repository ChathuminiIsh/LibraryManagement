package com.example.LibraryManagementApplication.Borrowing;

import com.example.LibraryManagementApplication.Book.Book;
import com.example.LibraryManagementApplication.Member.Member;
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
