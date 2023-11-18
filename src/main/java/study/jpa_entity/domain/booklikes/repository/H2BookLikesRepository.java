package study.jpa_entity.domain.booklikes.repository;

import org.springframework.stereotype.Repository;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.booklikes.entity.BookLikes;
import study.jpa_entity.domain.member.entity.Member;

import java.util.Optional;

@Repository
public abstract class H2BookLikesRepository implements BookLikesRepository{

    @Override
    public Optional<BookLikes> findByMemberAndBook(Member member, Book book) {
        Optional<BookLikes> bookLikes_memberId = findById(member.getId());
        Optional<BookLikes> bookLikes = findById(book.getId());
        return bookLikes;
    }
}
