package study.jpa_entity.domain.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.book.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
// Transactional(springframework) : 메서드를 실행하다 오류가 터졌을때 commit을 할지 rollback을 할지 자동으로 결정
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 책을 등록하는 기능
    public void saveBook(Book book){
        bookRepository.save(book);
    }

    // 모든 책 조회하는 기능
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    // bookId로 책 조회하는 기능
    public Optional<Book> getBookById(Long bookId){
        return bookRepository.findById(bookId);
    }
}
