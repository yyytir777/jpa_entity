package study.jpa_entity.domain.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.jpa_entity.domain.book.dto.BookRequestDto;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.book.repository.BookRepository;
import study.jpa_entity.domain.bookcategory.entity.BookCategory;
import study.jpa_entity.domain.bookcategory.repository.BookCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
// Transactional(springframework) : 메서드를 실행하다 오류가 터졌을때 commit을 할지 rollback을 할지 자동으로 결정
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final BookCategoryRepository bookCategoryRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
        this.bookRepository = bookRepository;
        this.bookCategoryRepository = bookCategoryRepository;
    }

    // 책을 등록하는 기능
    public void saveBook(BookRequestDto bookRequestDto){
        BookCategory bookCategory = bookCategoryRepository.getById(bookRequestDto.getBook_category_id());
        Book newBook = Book.builder()
            .id(bookRequestDto.getId())
            .name(bookRequestDto.getName())
            .price(bookRequestDto.getPrice())
            .bookCategory(bookCategory).build();
        bookRepository.save(newBook);
    }

    // 모든 책 조회하는 기능
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    // bookId로 책 조회하는 기능
    public Optional<Book> getBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }
}
