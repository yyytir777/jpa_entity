package study.jpa_entity.domain.member.service;

import study.jpa_entity.domain.member.dto.MemberRequestDto;
import study.jpa_entity.domain.member.entity.Member;

import java.util.List;

public interface MemberService {

    void join(MemberRequestDto memberRequestDto);

    String login(MemberRequestDto memberRequestDto);

    List<Member> findAll();

    void withdraw(Long userId);
}
