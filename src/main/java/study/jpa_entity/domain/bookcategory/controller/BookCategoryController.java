package study.jpa_entity.domain.bookcategory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.jpa_entity.domain.bookcategory.service.BookCategoryService;

import study.jpa_entity.domain.bookcategory.entity.BookCategory;

import java.util.List;

@RestController
@RequestMapping("/book-category")
public class BookCategoryController {

    private final BookCategoryService bookCategoryService;

    @Autowired
    public BookCategoryController(BookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    // Book Category 등록
    @PostMapping
    public void addBookCategory(@RequestBody BookCategory newbookCategory){
        bookCategoryService.saveBookCategory(newbookCategory);
    }

    // Book Category 모두 조회
    @GetMapping
    public List<BookCategory> getAllBookCategory(){
        List<BookCategory> bookCategories = bookCategoryService.getAllBookCategory();
        return bookCategories;
    }

    // Book Category 삭제
    @DeleteMapping("/{book-category-id}")
    public void deleteBookCategory(@PathVariable("book-category-id") Long bookCategoryId){
        bookCategoryService.deleteBookCategory(bookCategoryId);
    }
}
