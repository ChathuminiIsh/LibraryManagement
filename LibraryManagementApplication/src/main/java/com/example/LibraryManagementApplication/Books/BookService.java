package com.example.LibraryManagementApplication.Books;

import com.example.LibraryManagementApplication.Authors.Author;
import com.example.LibraryManagementApplication.Authors.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public AuthorRepository authorRepository;

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id){

        return  bookRepository.findById(id).orElse(null);
    }

    public Book addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setISBN(bookDTO.getISBN());
        book.setTitle(bookDTO.getTitle());
        book.setGenre(bookDTO.getGenre());
        book.setPrice(bookDTO.getPrice());
        book.setPublishedDate(bookDTO.getPublishedDate());
        book.setStatus(bookDTO.getStatus());
        book.setCreatedAt(java.time.LocalDateTime.now());

        return bookRepository.save(book);
    }

    public Book updateBook(int id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setISBN(bookDTO.getISBN());
            book.setTitle(bookDTO.getTitle());
            book.setGenre(bookDTO.getGenre());
            book.setPrice(bookDTO.getPrice());
            book.setPublishedDate(bookDTO.getPublishedDate());
            book.setStatus(bookDTO.getStatus());

            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}






