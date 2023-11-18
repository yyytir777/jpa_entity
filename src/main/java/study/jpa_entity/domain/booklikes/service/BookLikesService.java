package study.jpa_entity.domain.booklikes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.book.repository.BookRepository;
import study.jpa_entity.domain.booklikes.entity.BookLikes;
import study.jpa_entity.domain.booklikes.repository.BookLikesRepository;
import study.jpa_entity.domain.member.entity.Member;
import study.jpa_entity.domain.member.repository.MemberRepository;

import java.util.Optional;

@Service
public class BookLikesService {

    @Autowired
    private BookLikesRepository bookLikesRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;


    private Long id = 0L;

    public void likeBook(Member member, Book book){
        BookLikes bookLikes = new BookLikes(id, member, book);
        bookLikesRepository.save(bookLikes);
        id++;
    }

    public void unlikeBook(Member member, Book book){
        Optional<BookLikes> bookLikes = bookLikesRepository.findByMemberAndBook(member, book);
        bookLikesRepository.delete(bookLikes.get());
    }

    // 책 like
    public void likeBook(Long bookId, Long memberId){
        // bookId, memberId로는 member, book 객체 생성 x
        // bookId, memberId로 각각 해당하는 객체 불러오기
        Book book = bookRepository.findById(bookId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();

        BookLikes bookLikes = new BookLikes(id, member, book);
        bookLikesRepository.save(bookLikes);
    }


    // 책 unlike
    public void unlikeBook(Long bookId, Long memberId){
        // bookId, memberId로 레코드 찾기
        Optional<BookLikes> bookLikes = bookLikesRepository.findByBookIdAndMemberId(bookId, memberId);
        bookLikesRepository.delete(bookLikes.get());
    }
}
