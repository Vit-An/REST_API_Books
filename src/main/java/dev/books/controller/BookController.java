package dev.books.controller;

import dev.books.model.Book;
import dev.books.model.dto.BookDto;
import dev.books.model.dto.CountByGenreDto;
import dev.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adminapi/v1")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/authors/{idAuthor}/books")
    public Book createBook(@RequestBody BookDto bookDto,
                           @PathVariable(value = "idAuthor") Long idAuthor
    ){
        return bookService.createBook(bookDto, idAuthor);
    }

    @GetMapping("/books/{idBook}")
    public Book readBook(@PathVariable(value = "idBook") Long idBook
    ){
        return bookService.readBook(idBook);
    }

    @PatchMapping("/books/{idBook}")
    public Book updateBook(@RequestBody BookDto bookDto,
                           @PathVariable(value = "idBook") Long idBook
    ){
        return bookService.updateBook(bookDto, idBook);
    }

    @DeleteMapping("/books/{idBook}")
    public boolean deleteBook(@PathVariable(value = "idBook") Long idBook
    ){
        return bookService.deleteBook(idBook);
    }

    @GetMapping("/books/getBookWithPopularAuthors")
    public List<Book> getBookWithPopularAuthors(){
        return bookService.getBookWithPopularAuthors();
    }

    @PatchMapping ("/books/{idBook}/authors/{idAuthor}")
    public boolean setAuthor(@PathVariable(value = "idBook") Long idBook,
                          @PathVariable(value = "idAuthor") Long idAuthor){
        return bookService.setAuthor(idBook, idAuthor);
    }

    @DeleteMapping ("/books/{idBook}/authors/{idAuthor}")
    public boolean removeAuthor(@PathVariable(value = "idBook") Long idBook,
                          @PathVariable(value = "idAuthor") Long idAuthor){
        return bookService.removeAuthor(idBook, idAuthor);
    }

    @GetMapping("/books/getBookByGenre")
    public List<CountByGenreDto> getBookByGenre(){
        return bookService.getBookByGenre();
    }
}