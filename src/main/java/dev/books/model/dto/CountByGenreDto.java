package dev.books.model.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountByGenreDto {
    Long countOfBooks;
    String genre;

}
