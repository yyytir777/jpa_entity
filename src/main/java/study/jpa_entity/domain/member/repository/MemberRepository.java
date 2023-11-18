package study.jpa_entity.domain.member.repository;

import study.jpa_entity.domain.member.entity.Member;
import java.util.List;

public interface MemberRepository {

    List<Member> findAll();

    void save(Member member);
}
