package com.example.LibraryManagementApplication.Members;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMember() {

        return memberRepository.findAll();
    }

    public Member getMemberById(int id) {

        return memberRepository.findById(id).orElse(null);
    }

    public Member addMember(MemberDTO memberDTO) {
        Member member = new Member();

        member.setMemberName(memberDTO.getMemberName());
        member.setEmail(memberDTO.getEmail());
        member.setPhoneNumber(memberDTO.getPhoneNumber());
        member.setCreatedAt(java.time.LocalDateTime.now());


        return memberRepository.save(member);
    }

    public Member updateMember(int id, MemberDTO memberDTO) {
        Member member = memberRepository.findById(id).orElse(null);

        if (member != null) {

            member.setMemberName(memberDTO.getMemberName());
            member.setEmail(memberDTO.getEmail());
            member.setPhoneNumber(memberDTO.getPhoneNumber());
            member.setUpdatedAt(java.time.LocalDateTime.now());

            return memberRepository.save(member);
        }
        return null;
    }
    public void deleteMember(int id) {
        memberRepository.deleteById(id);
    }
}