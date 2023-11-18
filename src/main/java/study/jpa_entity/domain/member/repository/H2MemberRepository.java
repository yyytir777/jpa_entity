package study.jpa_entity.domain.member.repository;

import org.springframework.stereotype.Repository;
import study.jpa_entity.domain.member.entity.Member;

import java.util.List;

@Repository
public abstract class H2MemberRepository implements MemberRepository{
    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public
}
