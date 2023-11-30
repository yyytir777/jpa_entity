package study.jpa_entity.domain.bookcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.jpa_entity.domain.book.entity.Book;

import java.util.List;

@Service
public class BookCategoryService {

    private final BookCategoryRepository bookCategoryRepository;

    @Autowired
    public BookCategoryService(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    // 카테고리 등록하는 기능
    public void saveBookCategory(BookCategory bookCategory) {
        bookCategoryRepository.save(bookCategory);
    }

    // 모든 카테고리 조회하는 기능
    public List<BookCategory> getAllBookCategory() {
        return bookCategoryRepository.findAll();
    }

    // Id로 조회하는 기능
    public BookCategory findById(Long BookCategoryId){
        return bookCategoryRepository.findById(BookCategoryId).orElseThrow();
    }
}
