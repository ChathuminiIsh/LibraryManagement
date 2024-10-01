package com.example.LibraryManagementApplication.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author addAuthor(AuthorDTO authorDTO) {
        Author author = new Author();

        author.setAuthorName(authorDTO.getAuthorName());
        author.setBio(authorDTO.getBio());

        return authorRepository.save(author);
    }

    public Author updateAuthor(int id, AuthorDTO authorDTO) {

        Author author = authorRepository.findById(id).orElse(null);

        if (author != null) {
            author.setAuthorName(authorDTO.getAuthorName());
            author.setBio(authorDTO.getBio());

            return authorRepository.save(author);
        }
        return null;
    }

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }
}
