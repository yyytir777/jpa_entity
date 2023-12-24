package study.jpa_entity.domain.book.entity;

import lombok.*;
import study.jpa_entity.domain.book.dto.BookResponseDto;
import study.jpa_entity.domain.bookcategory.dto.BookCategoryDto;
import study.jpa_entity.domain.bookcategory.entity.BookCategory;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_category_id")
    private BookCategory bookCategory;

    public BookResponseDto toDto(){
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(this.getId());
        bookResponseDto.setName(this.getName());
        bookResponseDto.setPrice(this.getPrice());

        if (this.getBookCategory() != null){
            BookCategoryDto bookCategoryDto = new BookCategoryDto();
            bookCategoryDto.setId(this.getBookCategory().getId());
            bookCategoryDto.setName(this.getBookCategory().getName());
            bookResponseDto.setBookCategoryDto(bookCategoryDto);
        }

        return bookResponseDto;
    }
}