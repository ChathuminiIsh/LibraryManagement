package com.example.LibraryManagementApplication.ReturnBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/return_book")
public class ReturnBookController {
    @Autowired
    private ReturnBookService returnBookService;

    @GetMapping
    public List<ReturnBook> getAllReturnBooks() {
        return returnBookService.getAllReturnBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReturnBook> getReturnBookById(@PathVariable int id) {
       ReturnBook returnBook = returnBookService.getReturnBookById(id);
       if (returnBook != null){
           return  ResponseEntity.ok(returnBook);
       }
       return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ReturnBook> createReturnBook(@RequestBody ReturnBookDTO returnBookDTO) {
        return new ResponseEntity<>(returnBookService.createReturnBook(returnBookDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReturnBook> updateReturnBook(@PathVariable int id, @RequestBody ReturnBookDTO returnBookDTO) {
        return ResponseEntity.ok(returnBookService.updateReturnBook(id, returnBookDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReturnBook(@PathVariable int id) {
        returnBookService.deleteReturnBook(id);
        return ResponseEntity.noContent().build();
    }
}

