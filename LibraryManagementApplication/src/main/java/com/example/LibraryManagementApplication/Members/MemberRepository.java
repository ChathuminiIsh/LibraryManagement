package com.example.LibraryManagementApplication.Members;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member ,Integer> {
}
