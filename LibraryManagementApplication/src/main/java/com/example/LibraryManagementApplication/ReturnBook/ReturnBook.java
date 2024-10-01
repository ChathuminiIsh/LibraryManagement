package com.example.LibraryManagementApplication.ReturnBook;

import com.example.LibraryManagementApplication.Book.Book;
import com.example.LibraryManagementApplication.Member.Member;
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

    private long fine;

    public void calFine(LocalDate returnDate, LocalDate actualReturnDate) {
        this.returnDate = returnDate;
        this.actualReturnDate = actualReturnDate;

        if (actualReturnDate != null && returnDate != null) {
            long daysLate = ChronoUnit.DAYS.between(returnDate, actualReturnDate);
            setFine(daysLate > 0 ? daysLate * 100 : 0);
        }

    }
}

