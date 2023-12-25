package study.jpa_entity.domain.bookcategory.service;

import study.jpa_entity.domain.bookcategory.dto.BookCategoryDto;
import study.jpa_entity.domain.bookcategory.entity.BookCategory;

import java.util.List;

public interface BookCategoryService {

    void saveBookCategory(BookCategoryDto bookCategoryDto);

    List<BookCategory> getAllBookCategory();

    BookCategory findById(Long BookCategoryId);

    void deleteBookCategory(Long bookCategoryId);
}
