package com.example.LibraryManagementApplication.BookAuthor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book-authors")
public class BookAuthorController {

    @Autowired
    private BookAuthorService bookAuthorService;


    @GetMapping
    public List<BookAuthor> getAllBookAuthors() {
        return bookAuthorService.getAllBookAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookAuthor> getBookAuthorById(@PathVariable int id) {
        BookAuthor bookAuthor = bookAuthorService.getBookAuthorById(id);
        if (bookAuthor != null) {
            return ResponseEntity.ok(bookAuthor);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    public BookAuthor addBookAuthor(@RequestBody BookAuthorDTO bookAuthor) {
        return bookAuthorService.addBookAuthor(bookAuthor);
    }


    @PutMapping("/{id}")
    public ResponseEntity<BookAuthor> updateBookAuthor(@PathVariable int id, @RequestBody BookAuthorDTO bookAuthorDTO) {
        BookAuthor bookAuthor = bookAuthorService.updateBookAuthor(id, bookAuthorDTO);
        if (bookAuthor != null) {
            return ResponseEntity.ok(bookAuthor);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookAuthor(@PathVariable int id) {
        bookAuthorService.deleteBookAuthor(id);
        return ResponseEntity.noContent().build();
    }
}



