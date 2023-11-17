package study.jpa_entity.domain.hashTag.entity;

import jakarta.persistence.*;
import lombok.*;
import study.jpa_entity.domain.book.entity.BookHashTag;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class HashTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "hashTag", cascade = CascadeType.ALL)
    private List<BookHashTag> bookHashTagList = new ArrayList<>();
}
