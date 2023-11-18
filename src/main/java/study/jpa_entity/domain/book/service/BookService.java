package study.jpa_entity.domain.book.service;

import org.springframework.stereotype.Service;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.book.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

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
