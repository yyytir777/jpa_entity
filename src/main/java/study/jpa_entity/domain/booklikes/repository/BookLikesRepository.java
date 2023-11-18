package study.jpa_entity.domain.booklikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.booklikes.entity.BookLikes;
import study.jpa_entity.domain.member.entity.Member;

import java.util.Optional;

public interface BookLikesRepository extends JpaRepository<BookLikes, Long> {

    Optional<BookLikes> findByMemberAndBook(Member member, Book book);

    Optional<BookLikes> findByBookIdAndMemberId(Long bookId, Long memberId);
}
