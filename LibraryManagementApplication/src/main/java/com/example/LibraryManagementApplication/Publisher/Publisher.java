package com.example.LibraryManagementApplication.Publisher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("created_date")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm")
    public LocalDateTime createdAt;

    @JsonProperty("updated_date")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm")
    public LocalDateTime updatedAt;

}
