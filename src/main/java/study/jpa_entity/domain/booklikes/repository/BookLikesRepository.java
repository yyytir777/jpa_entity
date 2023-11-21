package study.jpa_entity.domain.booklikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.booklikes.entity.BookLikes;
import study.jpa_entity.domain.member.entity.Member;

import java.util.Optional;

public interface BookLikesRepository extends JpaRepository<BookLikes, Long> {

    Optional<BookLikes> findByBookIdAndMemberId(Long bookId, Long memberId);

    Long countByBookId(Long bookId);
}
