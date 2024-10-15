package com.example.LibraryManagementApplication.BookAuthor;

import com.example.LibraryManagementApplication.Author.Author;
import com.example.LibraryManagementApplication.Book.Book;
import jakarta.persistence.*;
import lombok.Data;

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
