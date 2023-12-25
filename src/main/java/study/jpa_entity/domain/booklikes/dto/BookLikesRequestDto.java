package study.jpa_entity.domain.booklikes.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookLikesRequestDto {
    private Long id;
    private Long book_id;
    private Long member_id;
}
