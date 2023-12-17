//package study.jpa_entity.domain.book.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import study.jpa_entity.domain.book.entity.Book;
//
//import java.util.List;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class BookAddRequestDto {
//
//    private Long id;
//    private String name;
//    private Long price;
//    private Long bookCategory_id;
//
//    public Book toEntity(){
//        Book newBook = Book.builder()
//                .id(this.id)
//                .name(this.name)
//                .price(this.price)
//                .bookCategory(findById(bookCategory_id))
//                .build();
//
//        return newBook;
//    }
//}
