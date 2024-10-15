package com.example.LibraryManagementApplication.BookAuthor;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BookAuthorId implements Serializable {
    private  int bookId;
    private int authorId;

    public BookAuthorId(int bookId, int authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }

}
