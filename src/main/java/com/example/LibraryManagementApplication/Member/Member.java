package com.example.LibraryManagementApplication.Member;

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

    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
