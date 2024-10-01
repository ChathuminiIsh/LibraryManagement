package com.example.LibraryManagementApplication.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBook();
    }


    @GetMapping("/{id}")
public ResponseEntity<Book> getBookById(@PathVariable int id){
    Book book = bookService.getBookById(id);
    if (book != null){
        return  ResponseEntity.ok(book);
    }
    return ResponseEntity.notFound().build();
}

@PostMapping
public Book addBook(@RequestBody BookDTO book){
    return bookService.addBook(book);
}

@PutMapping("/{id}")
public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody BookDTO bookDTO){
    Book updateBook = bookService.updateBook(id, bookDTO);

    if (updateBook != null){
        return  ResponseEntity.ok(updateBook);
    }
    return ResponseEntity.notFound().build();
}

@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id){
    bookService.deleteBook(id);
    return ResponseEntity.noContent().build();
}

}

