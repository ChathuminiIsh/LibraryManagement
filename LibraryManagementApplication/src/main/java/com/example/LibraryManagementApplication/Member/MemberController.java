package com.example.LibraryManagementApplication.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMember();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable int id) {
        Member member = memberService.getMemberById(id);

        if (member != null) {
            return ResponseEntity.ok(member);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Member addMember(@RequestBody MemberDTO memberDTO) {
        return memberService.addMember(memberDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable int id, @RequestBody MemberDTO memberDTO) {
        Member updateMember = memberService.updateMember(id, memberDTO);

        if (updateMember != null) {
            return ResponseEntity.ok(updateMember);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable int id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}


