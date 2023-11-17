package study.jpa_entity.domain.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.book.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    @GetMapping("/{book-id}")
    public Optional<Book> getBookById(@PathVariable("book-id") Long bookId){
        Optional<Book> book = bookRepository.findById(bookId);
        return book;
    }

    @PostMapping
    public void addBook(@RequestBody Book newBook){
        Book savedBook = bookRepository.save(newBook);
    }
}