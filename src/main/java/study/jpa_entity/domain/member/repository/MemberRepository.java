package study.jpa_entity.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.jpa_entity.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
