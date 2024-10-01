package com.example.LibraryManagementApplication.BookAuthor;


import com.example.LibraryManagementApplication.Authors.Author;
import com.example.LibraryManagementApplication.Books.Book;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"author_id", "book_id"})
})
public class BookAuthor {

    @EmbeddedId
    private BookAuthorId id;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @MapsId("authorId")
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;


}
