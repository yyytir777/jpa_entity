package study.jpa_entity.domain;

import jakarta.persistence.*;
import lombok.*;
import study.jpa_entity.domain.mapping.BookHashTag;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookHashTag> bookHashTagList = new ArrayList<>();
}