package dev.books.service;

import dev.books.model.Author;
import dev.books.model.Book;
import dev.books.model.dto.BookDto;
import dev.books.model.dto.CountByGenreDto;
import dev.books.repository.AuthorRepository;
import dev.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public Book createBook(@RequestBody BookDto bookDto,
                           @PathVariable(value = "idAuthor") Long idAuthor
    ){

        Book book = new Book(bookDto.getName(), bookDto.getPublished(), bookDto.getGenre(), bookDto.getRating());
        bookRepository.save(book);

        Author author = authorRepository.findOneById(idAuthor);
        author.getBooks().add(book);

        return book;
    }

    public Book readBook(@PathVariable(value = "idBook") Long idBook
    ){
        Book book = bookRepository.findOneById(idBook);
        return book;
    }

    public Book updateBook(@RequestBody BookDto bookDto,
                           @PathVariable(value = "idBook") Long idBook
    ){
        Book book = bookRepository.findOneById(idBook);

        book.setName(bookDto.getName());
        book.setPublished(bookDto.getPublished());
        book.setGenre(bookDto.getGenre());
        book.setRating(bookDto.getRating());
        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(@PathVariable(value = "idBook") Long idBook
    ){
        try {
            Book book = bookRepository.findOneById(idBook);
            bookRepository.delete(book);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<Book> getBookWithPopularAuthors(){
        List<Book> books = bookRepository.getBooksWithPopularAuthors();
        return books;
    }

    public boolean setAuthor(@PathVariable(value = "idBook") Long idBook,
                             @PathVariable(value = "idAuthor") Long idAuthor){
        Book book = bookRepository.findOneById(idBook);
        Author author = authorRepository.findOneById(idAuthor);
        author.getBooks().add(book);
        bookRepository.save(book);

        return true;
    }

    public boolean removeAuthor(@PathVariable(value = "idBook") Long idBook,
                                @PathVariable(value = "idAuthor") Long idAuthor){
        Book book = bookRepository.findOneById(idBook);
        Author author = authorRepository.findOneById(idAuthor);
        author.getBooks().remove(book);
        bookRepository.save(book);

        return true;
    }

    public List<CountByGenreDto> getBookByGenre(){

        return bookRepository.getBookByGenre();
    }
}
