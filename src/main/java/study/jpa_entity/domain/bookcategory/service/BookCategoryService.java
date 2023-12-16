package study.jpa_entity.domain.bookcategory.service;

import study.jpa_entity.domain.bookcategory.entity.BookCategory;

import java.util.List;

public interface BookCategoryService {

    void saveBookCategory(BookCategory bookCategory);

    List<BookCategory> getAllBookCategory();

    BookCategory findById(Long BookCategoryId);

    void deleteBookCategory(Long bookCategoryId);
}
