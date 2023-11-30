package study.jpa_entity.domain.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.jpa_entity.domain.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}