package study.jpa_entity.domain.member.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import study.jpa_entity.config.JwtTokenProvider;
import study.jpa_entity.domain.member.dto.MemberRequestDto;
import study.jpa_entity.domain.member.entity.Member;
import study.jpa_entity.domain.member.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public MemberServiceImpl(MemberRepository memberRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Transactional
    public void join(MemberRequestDto memberRequestDto){

        System.out.println(passwordEncoder.encode(memberRequestDto.getPassword()));

        Member member = Member.builder()
                .username(memberRequestDto.getUsername())
                .password(passwordEncoder.encode(memberRequestDto.getPassword()))
                .nickname(memberRequestDto.getNickname())
                .build();
        memberRepository.save(member);
    }

    public String login(MemberRequestDto memberRequestDto){
        Member member = memberRepository.findByUsername(memberRequestDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 username입니다."));

        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public void withdraw(Long userId) {

    }
}
