package com.example.LibraryManagementApplication.Borrowing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/borrowing")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @GetMapping
    public List<Borrowing> getAllBorrowings() {
        return borrowingService.getAllBorrowings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrowing> getBorrowingById(@PathVariable int id) {
        Borrowing borrowing = borrowingService.getBorrowingById(id);
        if (borrowing != null) {
            return ResponseEntity.ok(borrowing);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Borrowing addBorrowing(@RequestBody BorrowingDTO borrowingDTO) {
        return borrowingService.addBorrowing(borrowingDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Borrowing> updateSale(@PathVariable int id, @RequestBody BorrowingDTO borrowingDTO) {
        Borrowing updatedSale = borrowingService.updateBorrowing(id, borrowingDTO);
        if (updatedSale != null) {
            return ResponseEntity.ok(updatedSale);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowing(@PathVariable int id) {
        borrowingService.deleteBorrowing(id);
        return ResponseEntity.noContent().build();
    }

}
