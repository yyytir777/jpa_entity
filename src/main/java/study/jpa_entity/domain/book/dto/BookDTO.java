package study.jpa_entity.domain.book.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import study.jpa_entity.domain.book.entity.Book;
import study.jpa_entity.domain.bookcategory.BookCategory;


@Getter
@Builder
@AllArgsConstructor
public class BookDTO {

    private Long id;
    private String name;
    private Long price;
    private Long book_category_id;


    public Book toEntity(BookCategory bookCategory) {
        Book book = new Book(id, name, price, bookCategory);
        return book;
    }
}
