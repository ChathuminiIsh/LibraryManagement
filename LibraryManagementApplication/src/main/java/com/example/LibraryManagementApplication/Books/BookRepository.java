package com.example.LibraryManagementApplication.Books;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer>  {
}
