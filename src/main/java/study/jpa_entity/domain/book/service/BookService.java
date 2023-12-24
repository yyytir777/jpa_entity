package study.jpa_entity.domain.book.service;

import study.jpa_entity.domain.book.dto.BookRequestDto;
import study.jpa_entity.domain.book.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void saveBook(BookRequestDto bookRequestDto);

    List<Book> getAllBook();

    Optional<Book> getBookById(Long bookId);
}
