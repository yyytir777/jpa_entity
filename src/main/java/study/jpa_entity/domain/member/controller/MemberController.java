package study.jpa_entity.domain.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.jpa_entity.domain.member.entity.Member;
import study.jpa_entity.domain.member.repository.MemberRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping
    public List<Member> getAllUsers(){
        return memberRepository.findAll();
    }

    @PostMapping
    public void join(){

    }
}
