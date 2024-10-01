package com.example.LibraryManagementApplication.Books;


import com.example.LibraryManagementApplication.Authors.Author;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.time.LocalDateTime;
@Data
public class BookDTO {

    @JsonProperty("ISBN")
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

    @JsonProperty("created_date")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm")
    public LocalDateTime createdDate;


    @JsonProperty("status")
    public BookStatus status;

}
