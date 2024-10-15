package com.example.LibraryManagementApplication.Publisher;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PublisherDTO {

    @JsonProperty("publisher_name")
    public String publisherName;

    @JsonProperty("email")
    public String email;

    @JsonProperty("phone_number")
    public String phoneNumber;

}
