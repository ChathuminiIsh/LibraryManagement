package com.example.LibraryManagementApplication.Author;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthorDTO {

    @JsonProperty("author_name")
    public String authorName;

    @JsonProperty("bio")
    public String bio;

}
