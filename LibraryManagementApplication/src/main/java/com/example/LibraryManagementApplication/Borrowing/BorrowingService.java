package com.example.LibraryManagementApplication.Borrowing;

import com.example.LibraryManagementApplication.Book.Book;
import com.example.LibraryManagementApplication.Book.BookRepository;
import com.example.LibraryManagementApplication.Member.Member;
import com.example.LibraryManagementApplication.Member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingService {

    @Autowired
    private  BorrowingRepository borrowingRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    public Borrowing getBorrowingById(int id) {
        return borrowingRepository.findById(id).orElse(null);
    }

    public Borrowing addBorrowing(BorrowingDTO borrowingDTO) {
        Borrowing borrowing = new Borrowing();

        Member member = memberRepository.findById(borrowingDTO.getMemberId()).orElseThrow();
        borrowing.setMember(member);

        Book book = bookRepository.findById(borrowingDTO.getBookId()).orElseThrow();
        borrowing.setBook(book);

        borrowing.setBorrowDate(java.time.LocalDateTime.now());
        borrowing.setReturnDate(borrowingDTO.getReturnDate());

        return borrowingRepository.save(borrowing);
    }

    public Borrowing updateBorrowing(int id, BorrowingDTO borrowingDTO) {
        Borrowing borrowing = borrowingRepository.findById(id).orElse(null);
        if (borrowing != null) {

            Member member = memberRepository.findById(borrowingDTO.getMemberId()).orElseThrow();
            borrowing.setMember(member);

            Book book = bookRepository.findById(borrowingDTO.getBookId()).orElseThrow();
            borrowing.setBook(book);

            borrowing.setReturnDate(borrowingDTO.getReturnDate());

            return borrowingRepository.save(borrowing);
        }
        return null;
    }

    public void deleteBorrowing(int id) {
        bookRepository.deleteById(id);
    }

}
