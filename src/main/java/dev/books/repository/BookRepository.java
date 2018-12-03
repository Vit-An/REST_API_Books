package dev.books.repository;

import dev.books.model.Book;
import dev.books.model.dto.CountByGenreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findOneById (Long idBooks);

    @Query("SELECT b FROM Book b " +
            "INNER JOIN b.authors a " +
            "INNER JOIN a.books b " +
            "GROUP BY b.id " +
            "HAVING COUNT(b) > 1 ")
    List<Book> getBooksWithPopularAuthors();

    @Query("SELECT new dev.books.model.dto.CountByGenreDto(COUNT(b.id), b.genre) FROM Book b " +
            "GROUP BY b.genre ")
    List<CountByGenreDto> getBookByGenre();
}
