package com.example.LibraryManagementApplication.BookAuthor;

import com.example.LibraryManagementApplication.Author.Author;
import com.example.LibraryManagementApplication.Author.AuthorRepository;
import com.example.LibraryManagementApplication.Book.Book;
import com.example.LibraryManagementApplication.Book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAuthorService {

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<BookAuthor> getAllBookAuthors(){
        return bookAuthorRepository.findAll();
    }

    public BookAuthor getBookAuthorById(int id) {
        return bookAuthorRepository.findById(id).orElse(null);
    }

    public BookAuthor addBookAuthor(BookAuthorDTO bookAuthorDTO) {

        BookAuthor bookAuthor = new BookAuthor();

        BookAuthorId bookAuthorId = new BookAuthorId(bookAuthorDTO.getBookId(), bookAuthorDTO.getAuthorId());
        bookAuthor.setId(bookAuthorId);

        Book book = bookRepository.findById(bookAuthorDTO.getBookId()).orElseThrow();
        bookAuthor.setBook(book);

        Author author = authorRepository.findById(bookAuthorDTO.getAuthorId()).orElseThrow();
        bookAuthor.setAuthor(author);

        return bookAuthorRepository.save(bookAuthor);
    }

    public BookAuthor updateBookAuthor(int id, BookAuthorDTO bookAuthorDTO) {
        BookAuthor bookAuthor = bookAuthorRepository.findById(id).orElse(null);
        if (bookAuthor != null) {

            Book book = bookRepository.findById(bookAuthorDTO.getBookId()).orElseThrow();
            bookAuthor.setBook(book);

            Author author = authorRepository.findById(bookAuthorDTO.getAuthorId()).orElseThrow();
            bookAuthor.setAuthor(author);

            return bookAuthorRepository.save(bookAuthor);
        }
        return null;
    }

    public void deleteBookAuthor(int id) {
        bookAuthorRepository.deleteById(id);
    }

}
