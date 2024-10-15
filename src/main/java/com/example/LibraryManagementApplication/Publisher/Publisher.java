package com.example.LibraryManagementApplication.Publisher;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int publisherId;

    public String publisherName;

    @Column(unique = true)
    public String email;

    public String phoneNumber;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

}
