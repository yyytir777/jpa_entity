package study.jpa_entity.domain.bookcategory.entity;

import lombok.*;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.bookcategory.dto.BookCategoryDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public BookCategoryDto toDto(){
        BookCategoryDto bookCategoryDto = BookCategoryDto.builder()
                .id(this.getId())
                .name(this.getName()).build();

        return bookCategoryDto;
    }
}