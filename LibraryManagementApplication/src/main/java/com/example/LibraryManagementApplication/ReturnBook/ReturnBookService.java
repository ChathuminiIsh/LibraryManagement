package com.example.LibraryManagementApplication.ReturnBook;

import com.example.LibraryManagementApplication.Books.Book;
import com.example.LibraryManagementApplication.Books.BookRepository;
import com.example.LibraryManagementApplication.Members.Member;
import com.example.LibraryManagementApplication.Members.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class ReturnBookService {

    @Autowired
  private ReturnBookRepository returnBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<ReturnBook> getAllReturnBooks() {
        return returnBookRepository.findAll();
    }

    public ReturnBook getReturnBookById(int id){
        return returnBookRepository.findById(id).orElse(null);
    }


    public ReturnBook createReturnBook(ReturnBookDTO returnBookDTO) {

        ReturnBook returnBook = new ReturnBook();

        Book book = bookRepository.findById(returnBookDTO.getBookId()).orElseThrow();
        returnBook.setBook(book);

        Member member = memberRepository.findById(returnBookDTO.getMemberId()).orElseThrow();
        returnBook.setMember(member);

        returnBook.setBorrowDate(returnBookDTO.getBorrowDate());
        returnBook.setReturnDate(returnBookDTO.getReturnDate());
        returnBook.setActualReturnDate(returnBookDTO.getActualReturnDate());


        if (returnBook.getActualReturnDate() != null && returnBook.getReturnDate() != null) {
            long daysLate = ChronoUnit.DAYS.between(returnBook.getReturnDate(), returnBook.getActualReturnDate());
            returnBook.setFine(daysLate > 0 ? daysLate * 100 : 0);
        }

        return returnBookRepository.save(returnBook);
    }

    public ReturnBook updateReturnBook(int id, ReturnBookDTO returnBookDTO) {
        ReturnBook returnBook = returnBookRepository.findById(id).orElseThrow();

        Book book = bookRepository.findById(returnBookDTO.getBookId()).orElseThrow();
        returnBook.setBook(book);

        Member member = memberRepository.findById(returnBookDTO.getMemberId()).orElseThrow();
        returnBook.setMember(member);

        returnBook.setBorrowDate(returnBookDTO.getBorrowDate());
        returnBook.setReturnDate(returnBookDTO.getReturnDate());
        returnBook.setActualReturnDate(returnBookDTO.getActualReturnDate());


        if (returnBook.getActualReturnDate() != null && returnBook.getReturnDate() != null) {
            long daysLate = ChronoUnit.DAYS.between(returnBook.getReturnDate(), returnBook.getActualReturnDate());
            returnBook.setFine(daysLate > 0 ? daysLate * 100 : 0);
        }

        return returnBookRepository.save(returnBook);
    }

    public void deleteReturnBook(int id) {
        returnBookRepository.deleteById(id);
    }
}
