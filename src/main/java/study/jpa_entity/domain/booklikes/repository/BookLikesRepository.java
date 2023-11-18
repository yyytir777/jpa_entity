package study.jpa_entity.domain.booklikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.booklikes.entity.BookLikes;
import study.jpa_entity.domain.member.entity.Member;

import java.util.Optional;

public interface BookLikesRepository {

    Optional<BookLikes> findByMemberAndBook(Member member, Book book);

    void delete(Optional<BookLikes> bookLikes);
}
