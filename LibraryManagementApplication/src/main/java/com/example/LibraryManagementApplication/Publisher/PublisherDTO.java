package com.example.LibraryManagementApplication.Publisher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PublisherDTO {

    @JsonProperty("publisher_name")
    public String publisherName;

    @JsonProperty("email")
    public String email;

    @JsonProperty("phone_number")
    public String phoneNumber;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm")
    @JsonProperty("created_at")
    public LocalDateTime createdAt;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm")
    @JsonProperty("updated_at")
    public LocalDateTime updatedAt;
}
