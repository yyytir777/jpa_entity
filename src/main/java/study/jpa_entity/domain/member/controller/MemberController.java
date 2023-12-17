package study.jpa_entity.domain.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.jpa_entity.domain.member.dto.MemberDTO;
import study.jpa_entity.domain.member.entity.Member;
import study.jpa_entity.domain.member.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MemberController {

    @Autowired
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원가입
    @PostMapping("/join")
    public void joinMember(@RequestBody MemberDTO memberDTO){
        memberService.join(memberDTO);

    }

    // 회원탈퇴
    @DeleteMapping("/withdraw")
    public void WithdrawMember(){

    }

    // 로그인
    @PostMapping("/login")
    public void login(@RequestParam MemberDTO memberDTO){
        memberService.login(memberDTO);
    }

    // 로그아웃
    @PostMapping("/logout")
    public void logout(){

    }

    // 회원 정보 수정
    @PatchMapping("/{userId}")


    // 모든 회원 정보 조회
    @GetMapping
    public List<Member> getAllUsers(){
        return memberService.findAll();
    }
}
