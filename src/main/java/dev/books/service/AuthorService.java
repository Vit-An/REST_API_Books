package dev.books.service;

import dev.books.model.Author;
import dev.books.model.dto.AuthorDto;
import dev.books.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public Author createAuthor(@RequestBody AuthorDto authorDto){
        Author author = new Author(authorDto.getName(),authorDto.getGender(), authorDto.getBorn());
        authorRepository.save(author);
        return author;
    }

    public Author readAuthor(@PathVariable(value = "idAuthor") Long idAuthor){
        Author author = authorRepository.findOneById(idAuthor);
        return author;
    }

    public Author updateAuthor(@RequestBody AuthorDto authorDto,
                               @PathVariable(value = "idAuthor") Long idAuthor
    ){
        Author author = authorRepository.findOneById(idAuthor);

        author.setName(authorDto.getName());
        author.setGender(authorDto.getGender());
        author.setBorn(authorDto.getBorn());

        authorRepository.save(author);
        return author;
    }

    public boolean deleteAuthor(@PathVariable(value = "idAuthor") Long idAuthor
    ){
        try {
            Author author = authorRepository.findOneById(idAuthor);
            authorRepository.delete(author);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<Author> getAuthorMore55years(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -55);
        Date dateBefore55Years = cal.getTime();
        List<Author> authors = authorRepository.findByBornBeforeOrderByBorn(dateBefore55Years);
        return authors;
    }

    public Author getMostPopularAuthor(){
        List<Author> authors =  authorRepository.getMostPopularAuthor();
        return authors.get(0);
    }
}
