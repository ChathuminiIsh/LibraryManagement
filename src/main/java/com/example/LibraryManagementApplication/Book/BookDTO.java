package com.example.LibraryManagementApplication.Book;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.time.LocalDateTime;
@Data
public class BookDTO {

    @JsonProperty("isbn")
    public String ISBN;

    @JsonProperty("title")
    public  String title;

    @JsonProperty("genre")
    public String genre;

    @JsonProperty("publisher_id")
    private int publisherId;

    @JsonProperty("price")
    public int price;

    @JsonProperty("published_date")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm")
    public LocalDateTime publishedDate;

    @JsonProperty("status")
    public BookStatus status;

}
