package study.jpa_entity.domain.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.jpa_entity.domain.member.dto.MemberRequestDto;
import study.jpa_entity.domain.member.entity.Member;
import study.jpa_entity.domain.member.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MemberController {

    @Autowired
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원가입
    @PostMapping("/join")
    public void joinMember(@RequestBody MemberRequestDto memberRequestDto){
        memberService.join(memberRequestDto);

    }

    // 회원탈퇴
    // 로그아웃 + db 삭제
    @DeleteMapping("/withdraw/{userId}")
    public void WithdrawMember(@PathVariable Long userId){
        /**
         * withdraw : 회원 삭제
         */
        memberService.withdraw(userId);
    }

    // 로그인
    @PostMapping("/login")
    public void login(@RequestParam MemberRequestDto memberRequestDto){
        memberService.login(memberRequestDto);
    }

    // 로그아웃
    // JWT정보에 대해 막는것을 등록
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
