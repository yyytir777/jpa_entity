package study.jpa_entity.domain.book.repository;

import study.jpa_entity.domain.book.entity.Book;

import java.util.List;
import java.util.Optional;

public class H2BookRepository implements BookRepository{

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return Optional.empty();
    }
}
