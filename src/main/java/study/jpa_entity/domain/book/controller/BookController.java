package study.jpa_entity.domain.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.jpa_entity.domain.book.dto.BookRequestDto;
import study.jpa_entity.domain.book.dto.BookResponseDto;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.book.service.BookService;
import study.jpa_entity.domain.bookcategory.dto.BookCategoryDto;
import study.jpa_entity.domain.booklikes.dto.BookLikesRequestDto;
import study.jpa_entity.domain.booklikes.entity.BookLikes;
import study.jpa_entity.domain.booklikes.service.BookLikesService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookLikesService bookLikesService;

    @Autowired
    public BookController(BookService bookService, BookLikesService bookLikesService) {
        this.bookService = bookService;
        this.bookLikesService = bookLikesService;
    }

    // 모든 책 조회
    @GetMapping
    public List<BookResponseDto> getAllBook() {
        List<Book> books = bookService.getAllBook();

        List<BookResponseDto> bookResponseDtos = books.stream()
                .map(Book::toDto)
                .collect(Collectors.toList());
        return bookResponseDtos;
    }

    // 책 조회
    @GetMapping("/{book-id}")
    public Optional<BookResponseDto> getBookById(@PathVariable("book-id") Long bookId) {
        Optional<Book> optionalBook = bookService.getBookById(bookId);

        if (optionalBook.isPresent()){
            Book book = optionalBook.get();
            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setId(book.getId());
            bookResponseDto.setName(book.getName());
            bookResponseDto.setPrice(book.getPrice());

            if (book.getBookCategory() != null){
                BookCategoryDto bookCategoryDto = new BookCategoryDto();
                bookCategoryDto.setId(book.getBookCategory().getId());
                bookCategoryDto.setName(book.getBookCategory().getName());
                bookResponseDto.setBookCategoryDto(bookCategoryDto);
            }

            return Optional.of(bookResponseDto);
        } else{
            return Optional.empty();
        }
    }

    // 책 등록
    @PostMapping
    public void addBook(@RequestBody BookRequestDto bookRequestDto) {
        bookService.saveBook(bookRequestDto);
        // BookService에서 저장하는 기능 생성
    }

    // 책 좋아요
    @PostMapping("/{bookId}/like")
    // "{id}"형태는 @PathVariable 형태로,
    public void likeBook(@PathVariable Long bookId, @RequestParam Long memberId) {
        BookLikesRequestDto bookLikesRequestDto = BookLikesRequestDto.builder()
                .book_id(bookId)
                .member_id(memberId).build();

        bookLikesService.likeBook(bookLikesRequestDto);
    }

    // 책 좋아요 취소
    @DeleteMapping("/{bookId}/unlike")
    public void unlikeBook(@PathVariable Long bookId, @RequestParam Long memberId) {
        bookLikesService.unlikeBook(bookId, memberId);
    }

    // 책 좋아요 개수
    @GetMapping("/{bookId}/like-count")
    public Long likeBookCount(@PathVariable Long bookId){
        return bookLikesService.likeBookCount(bookId);
    }
}