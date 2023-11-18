package study.jpa_entity.domain.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @PostMapping("/sign-up")
    public void RegisterMember(){

    }

    // 회원탈퇴
    @DeleteMapping("/withdraw")
    public void WithdrawMember(){

    }

    // 로그인
    @GetMapping
    public List<Member> getAllUsers(){
        return memberService.findAll();
    }

    @PostMapping
    public void join(){

    }
}
