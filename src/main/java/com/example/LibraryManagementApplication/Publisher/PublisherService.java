package com.example.LibraryManagementApplication.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAllPublisher() {
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(int id) {
        return publisherRepository.findById(id).orElse(null);
    }

    public Publisher addPublisher(PublisherDTO publisherDTO) {
        Publisher publisher = new Publisher();

        publisher.setPublisherName(publisherDTO.getPublisherName());
        publisher.setEmail(publisherDTO.getEmail());
        publisher.setPhoneNumber(publisherDTO.getPhoneNumber());
        publisher.setCreatedAt(java.time.LocalDateTime.now());
        publisher.setUpdatedAt(java.time.LocalDateTime.now());

        return publisherRepository.save(publisher);
    }

    public Publisher updatePublisher(int id, PublisherDTO publisherDTO ) {
        Publisher publisher = publisherRepository.findById(id).orElse(null);

        if (publisher != null) {

            publisher.setPublisherName(publisherDTO.getPublisherName());
            publisher.setEmail(publisherDTO.getEmail());
            publisher.setPhoneNumber(publisherDTO.getPhoneNumber());
            publisher.setUpdatedAt(java.time.LocalDateTime.now());

            return publisherRepository.save(publisher);
        }
        return null;
    }
    public void deletePublisher(int id) {
        publisherRepository.deleteById(id);
    }

}
