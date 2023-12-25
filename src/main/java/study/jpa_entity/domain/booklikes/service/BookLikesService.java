package study.jpa_entity.domain.booklikes.service;

import study.jpa_entity.domain.booklikes.dto.BookLikesRequestDto;

public interface BookLikesService {

    void likeBook(BookLikesRequestDto bookLikesRequestDto);

    void unlikeBook(Long bookId, Long memberId);

    Long likeBookCount(Long bookId);
}
