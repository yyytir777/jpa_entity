package study.jpa_entity.domain.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.book.service.BookService;
import study.jpa_entity.domain.booklikes.service.BookLikesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookLikesService bookLikesService;

    // 모든 책 조회
    @GetMapping
    public List<Book> getAllBook() {
        List<Book> books = bookService.getAllBook();
        return books;
    }

    // 책 조회
    @GetMapping("/{book-id}")
    public Optional<Book> getBookById(@PathVariable("book-id") Long bookId) {
        Optional<Book> book = bookService.getBookById(bookId);
        return book;
    }

    // 책 등록
    @PostMapping
    public void addBook(@RequestBody Book newBook) {
        bookService.saveBook(newBook);
        // BookService에서 저장하는 기능 생성
    }

    // 책 좋아요
    @PatchMapping("/{book-id}/like")
    // "{id}"형태는 @PathVariable 형태로,
    public void likeBook(@PathVariable Long bookId, @RequestParam Long memberId) {
        bookLikesService.likeBook(bookId, memberId);
    }

    // 책 좋아요 취소
    @PatchMapping("/{book-id}/unlike")
    public void unlikeBook(@PathVariable Long bookId, @RequestParam Long memberId) {
        bookLikesService.unlikeBook(bookId, memberId);
    }
}