package study.jpa_entity.domain.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.jpa_entity.domain.book.entity.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>  {
    public List<Book> findAll();

    public Optional<Book> findById(Long bookId);
}
