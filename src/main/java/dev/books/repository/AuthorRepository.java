package dev.books.repository;

import dev.books.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findOneById (Long idAuthors);

    List<Author> findByBornBeforeOrderByBorn(Date born);

    @Query("SELECT a FROM Author a " +
            "INNER JOIN a.books b " +
            "INNER JOIN b.authors a " +
            "GROUP BY a.id " +
            "ORDER BY COUNT(b.id) DESC")
    List<Author> getMostPopularAuthor();
}
