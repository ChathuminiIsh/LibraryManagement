package com.example.LibraryManagementApplication.Borrowing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BorrowingDTO {

    @JsonProperty("member_id")
    public int memberId;

    @JsonProperty("book_id")
    public int bookId;

    @JsonProperty("borrow_date")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm")
    public LocalDateTime borrowDate;

    @JsonProperty("return_date")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm")
    public LocalDateTime returnDate;
}
