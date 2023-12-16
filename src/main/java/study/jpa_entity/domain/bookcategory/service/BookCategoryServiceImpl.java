package study.jpa_entity.domain.bookcategory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.jpa_entity.domain.bookcategory.repository.BookCategoryRepository;
import study.jpa_entity.domain.bookcategory.entity.BookCategory;

import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService{

    private final BookCategoryRepository bookCategoryRepository;

    @Autowired
    public BookCategoryServiceImpl(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    // 카테고리 등록하는 기능
    @Override
    public void saveBookCategory(BookCategory bookCategory) {
        bookCategoryRepository.save(bookCategory);
    }

    // 모든 카테고리 조회하는 기능
    @Override
    public List<BookCategory> getAllBookCategory() {
        return bookCategoryRepository.findAll();
    }

    // Id로 조회하는 기능
    @Override
    public BookCategory findById(Long BookCategoryId){
        return bookCategoryRepository.findById(BookCategoryId).orElseThrow();
    }

    // Id로 삭제하는 기능
    @Override
    public void deleteBookCategory(Long bookCategoryId) {
        bookCategoryRepository.deleteById(bookCategoryId);
    }
}
