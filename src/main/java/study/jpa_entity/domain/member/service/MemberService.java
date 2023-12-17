package study.jpa_entity.domain.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import study.jpa_entity.config.JwtTokenProvider;
import study.jpa_entity.domain.member.dto.MemberDTO;
import study.jpa_entity.domain.member.entity.Member;
import study.jpa_entity.domain.member.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Transactional
    public Long join(MemberDTO memberDTO){
        Member member = Member.builder()
                .username(memberDTO.getUsername())
                .password(Long.parseLong(passwordEncoder.encode(memberDTO.getPassword())))
                .build();
        return memberRepository.save(member).getId();
    }

    public String login(MemberDTO memberDTO){
        Member member = memberRepository.findByUsername(memberDTO.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 username입니다."));

        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }
}
