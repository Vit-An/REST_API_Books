package dev.books.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    @NotBlank
    @Size (max=100)
    String name;

    @NonNull
    String published;

    @NonNull
    @NotBlank
    @Size(max=50)
    String genre;

    @NonNull
    int rating ;


    @JsonBackReference
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();
}