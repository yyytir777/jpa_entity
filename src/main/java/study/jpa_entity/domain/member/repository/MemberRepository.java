package study.jpa_entity.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.jpa_entity.domain.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
