package com.example.LibraryManagementApplication.Users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    @JsonProperty("user_name")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

    @JsonProperty("created_at")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;


    @JsonProperty("role")
    private UserRole role;
}
