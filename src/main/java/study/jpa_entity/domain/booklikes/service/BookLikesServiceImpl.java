package study.jpa_entity.domain.booklikes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.jpa_entity.domain.book.repository.BookRepository;
import study.jpa_entity.domain.booklikes.dto.BookLikesRequestDto;
import study.jpa_entity.domain.booklikes.entity.BookLikes;
import study.jpa_entity.domain.booklikes.repository.BookLikesRepository;
import study.jpa_entity.domain.member.repository.MemberRepository;

import java.util.Optional;

@Service
public class BookLikesServiceImpl implements BookLikesService{

    private final BookLikesRepository bookLikesRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public BookLikesServiceImpl(BookLikesRepository bookLikesRepository, BookRepository bookRepository, MemberRepository memberRepository) {
            this.bookLikesRepository = bookLikesRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }


    // 책 like
    public void likeBook(BookLikesRequestDto bookLikesRequestDto){
        // 이미 좋아요를 눌렀을 때
        Optional<BookLikes> optionalBookLikes = bookLikesRepository.findById(bookLikesRequestDto.getId());
        if (optionalBookLikes.isPresent()){
            return;
        }

        BookLikes bookLikes = BookLikes.builder()
                .id(bookLikesRequestDto.getId())
                .book(bookRepository.findById(bookLikesRequestDto.getBook_id()).get())
                .member(memberRepository.findById(bookLikesRequestDto.getMember_id()).get()).build();
        bookLikesRepository.save(bookLikes);
    }


    // 책 unlike
    public void unlikeBook(Long bookId, Long memberId){
        // bookId, memberId로 레코드 찾기
        Optional<BookLikes> bookLikes = bookLikesRepository.findByBookIdAndMemberId(bookId, memberId);
        if (bookLikes.isEmpty()){
            return;
        }
        bookLikesRepository.delete(bookLikes.get());
    }

    // 책 좋아요 개수
    public Long likeBookCount(Long bookId){
        return bookLikesRepository.countByBookId(bookId);
    }
}
