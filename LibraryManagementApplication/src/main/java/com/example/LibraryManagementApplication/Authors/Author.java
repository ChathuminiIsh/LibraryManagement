package com.example.LibraryManagementApplication.Authors;

import com.example.LibraryManagementApplication.BookAuthor.BookAuthor;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int authorId;

    public String authorName;
    public String bio;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<BookAuthor> bookAuthors = new HashSet<>();
}
