package com.example.LibraryManagementApplication.ReturnBook;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReturnBookDTO {

    @JsonProperty("book_id")
    private int bookId;

    @JsonProperty("member_id")
    private int memberId;

    @JsonProperty("borrow_date")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm")
    private LocalDate borrowDate;

    @JsonProperty("return_date")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm")
    private LocalDate returnDate;

    @JsonProperty("actual_date")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm")
    private LocalDate actualReturnDate;


    private long fine;
}
