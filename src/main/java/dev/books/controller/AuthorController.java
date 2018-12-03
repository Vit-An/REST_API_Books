package dev.books.controller;

import dev.books.model.Author;
import dev.books.model.dto.AuthorDto;
import dev.books.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adminapi/v1/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping
    public Author createAuthor(@RequestBody AuthorDto authorDto){
        return authorService.createAuthor(authorDto);
    }

    @GetMapping("/{idAuthor}")
    public Author readAuthor(@PathVariable(value = "idAuthor") Long idAuthor
    ){
        return authorService.readAuthor(idAuthor);
    }

    @PatchMapping("/{idAuthor}")
    public Author updateAuthor(@RequestBody AuthorDto authorDto,
                               @PathVariable(value = "idAuthor") Long idAuthor
    ){
       return authorService.updateAuthor(authorDto, idAuthor);
    }

    @DeleteMapping("/{idAuthor}")
    public boolean deleteAuthor(@PathVariable(value = "idAuthor") Long idAuthor
    ){
        return authorService.deleteAuthor(idAuthor);
    }

    @GetMapping("/getMoreThen55Years")
    public List<Author> getAuthorMore55years(){
        return authorService.getAuthorMore55years();
    }

    @GetMapping("/getMostPopularAuthor")
    public Author getMostPopularAuthor(){
        return authorService.getMostPopularAuthor();
    }
}
