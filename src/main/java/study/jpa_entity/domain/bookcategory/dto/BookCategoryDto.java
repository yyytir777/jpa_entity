package study.jpa_entity.domain.bookcategory.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookCategoryDto {
    private Long id;
    private String name;
}