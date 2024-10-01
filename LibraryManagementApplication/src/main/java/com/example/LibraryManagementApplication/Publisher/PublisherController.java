package com.example.LibraryManagementApplication.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public List<Publisher> getAllPublisher() {
        return publisherService.getAllPublisher();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable int id) {
        Publisher publisher = publisherService.getPublisherById(id);

        if (publisher != null) {
            return ResponseEntity.ok(publisher);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Publisher addPublisher(@RequestBody PublisherDTO publisherDTO) {
        return publisherService.addPublisher(publisherDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable int id, @RequestBody PublisherDTO publisherDTO) {
        Publisher updatePublisher = publisherService.updatePublisher(id, publisherDTO);

        if (updatePublisher != null) {
            return ResponseEntity.ok(updatePublisher);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable int id) {
        publisherService.deletePublisher(id);
        return ResponseEntity.noContent().build();
    }

}
