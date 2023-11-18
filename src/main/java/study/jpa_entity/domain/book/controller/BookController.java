package study.jpa_entity.domain.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.book.repository.BookRepository;
import study.jpa_entity.domain.booklikes.service.BookLikesService;
import study.jpa_entity.domain.member.entity.Member;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookLikesService bookLikesService;

    // 모든 책 조회
    @GetMapping
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    // 책 조회
    @GetMapping("/{book-id}")
    public Optional<Book> getBookById(@PathVariable("book-id") Long bookId){
        Optional<Book> book = bookRepository.findById(bookId);
        return book;
    }

    // 책 등록
    @PostMapping
    public void addBook(@RequestBody Book newBook){
        Book savedBook = bookRepository.save(newBook);
    }

    // 책 좋아요
    @PatchMapping("/{book-id}/like")
    public void likeBook(@PathVariable Long bookId, @RequestParam Long userId){
        likeBook(bookId, userId);
    }

    // 책 좋아요 취소
    @PatchMapping("/{book-id}/like")
    public void unlikeBook(@PathVariable Long bookId, @RequestParam Long userId){
        unlikeBook(bookId, userId);
    }
}