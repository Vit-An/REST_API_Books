package dev.books.model.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    String name;
    String published;
    String genre;
    int rating ;
}
