package com.example.LibraryManagementApplication.Members;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int memberId;

    public String memberName;

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
