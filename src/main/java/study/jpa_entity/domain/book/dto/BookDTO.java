package study.jpa_entity.domain.book.dto;

import study.jpa_entity.domain.book.entity.Book;

public class BookDTO {

    private String name;
    private Long price;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
