package study.jpa_entity.domain.bookcategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

    // @Query로 사용자 정의 query 작성 가능

}