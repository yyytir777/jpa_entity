package study.jpa_entity.domain.book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.jpa_entity.domain.bookcategory.dto.BookCategoryDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {

    private Long id;
    private String name;
    private Long price;
    private BookCategoryDto bookCategoryDto;
}
