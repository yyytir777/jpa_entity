package study.jpa_entity.domain.bookcategory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.jpa_entity.domain.bookcategory.entity.BookCategory;


public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

    // @Query로 사용자 정의 query 작성 가능

}