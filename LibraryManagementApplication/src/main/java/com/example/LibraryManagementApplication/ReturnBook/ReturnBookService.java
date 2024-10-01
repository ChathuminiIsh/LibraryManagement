package com.example.LibraryManagementApplication.ReturnBook;

import com.example.LibraryManagementApplication.Book.Book;
import com.example.LibraryManagementApplication.Book.BookRepository;
import com.example.LibraryManagementApplication.Member.Member;
import com.example.LibraryManagementApplication.Member.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        returnBook.calFine(returnBookDTO.getReturnDate(), returnBookDTO.getActualReturnDate());

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

        returnBook.calFine(returnBookDTO.getReturnDate(), returnBookDTO.getActualReturnDate());

        return returnBookRepository.save(returnBook);
    }

    public void deleteReturnBook(int id) {
        returnBookRepository.deleteById(id);
    }

}
