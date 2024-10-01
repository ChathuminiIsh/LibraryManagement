package com.example.LibraryManagementApplication.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthor();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable int id){

        Author author = authorService.getAuthorById(id);

        if(author != null){
            return ResponseEntity.ok(author);
        }
        return ResponseEntity.notFound().build();
    }

@PostMapping
  public Author addAuthor(@RequestBody AuthorDTO authorDTO){

        return authorService.addAuthor(authorDTO);
 }

@PutMapping("/{id}")
 public ResponseEntity<Author> updateAuthor(@PathVariable int id, @RequestBody AuthorDTO authorDTO){
        Author updateAuthor = authorService.updateAuthor(id, authorDTO);

        if(updateAuthor != null) {
            return ResponseEntity.ok(updateAuthor);
        }
        return  ResponseEntity.notFound().build();
}

@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable int id){
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
}
}


