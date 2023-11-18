package study.jpa_entity.domain.book.entity;

import jakarta.persistence.*;
import lombok.*;
import study.jpa_entity.domain.book.entity.Book;

import java.util.ArrayList;
import java.util.List;

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

}