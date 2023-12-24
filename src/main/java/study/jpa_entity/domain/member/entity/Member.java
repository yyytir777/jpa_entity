package study.jpa_entity.domain.member.entity;

import lombok.*;
import study.jpa_entity.domain.member.entity.enums.Gender;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 해당 클래스를 JPA Entity로 지정
@Getter // lombok 라이브러리 : 자동으로 getter 메서드 생성 -> JPA에서 entity 클래스에 접근하기 위함
@Builder // 객체를 생성할때 순서를 신경 안쓰고 entity 생성할 수 있게 함
// PROTECTED : 외부에서 인스턴스를 생성하지 못하게 함
// NoArgsConstructor & AllArgsConstructor : 파라미터가 없는 생성자, 모든 필드를 인자로 하는 생성자를 자동으로 생성
// entity를 생성하고 조회할때 필요
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    // Primary key 지정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 150)
    private String password;

    @Column(nullable = false, length = 30)
    private String nickname;
    
    // @Enumerated 어노테이션을 사용한 enum 적용
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10)")
    private Gender gender;

    @ElementCollection(fetch = FetchType.EAGER) //roles 컬렉션
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    // mappedBy : 연관관계의 주인
    // cascade : entity 변경이나 삭제같은 연산에서 자식 entity에 어떤 영향을 줄건지
    // cascade.all : 모든 연산에 대해 cascade 적용
    // cascade.persist : 새로운 entity를 추가할때만 cascade 적용
    // cascade.merge : entity를 병합할때만 cascade 적용
    // ...
}