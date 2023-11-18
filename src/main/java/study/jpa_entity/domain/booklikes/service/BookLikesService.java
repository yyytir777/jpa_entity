package study.jpa_entity.domain.booklikes.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.booklikes.entity.BookLikes;
import study.jpa_entity.domain.booklikes.repository.BookLikesRepository;
import study.jpa_entity.domain.member.entity.Member;

import java.util.Optional;

@Service
public class BookLikesService {

    @Autowired
    private BookLikesRepository bookLikesRepository;

    private Long id = 0L;

    @Transactional
    public void likeBook(Member member, Book book){
        BookLikes bookLikes = new BookLikes(id, member, book);
        bookLikesRepository.save(bookLikes);
        id++;
    }

    public void unlikeBook(Member member, Book book){
        Optional<BookLikes> bookLikes = bookLikesRepository.findByMemberAndBook(member, book);
        bookLikesRepository.delete(bookLikes);
    }
}
