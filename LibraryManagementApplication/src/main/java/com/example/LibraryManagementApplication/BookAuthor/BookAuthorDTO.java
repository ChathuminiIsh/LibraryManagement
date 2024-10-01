package com.example.LibraryManagementApplication.BookAuthor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookAuthorDTO {

    @JsonProperty("book_id")
    private int bookId;

    @JsonProperty("author_id")
    private int authorId;
}
