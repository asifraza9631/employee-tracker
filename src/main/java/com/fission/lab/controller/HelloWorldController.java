package com.fission.lab.controller;


import com.fission.lab.model.Author;
import com.fission.lab.model.Book;
import com.fission.lab.repository.AuthorRepository;
import com.fission.lab.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/v1")
public class HelloWorldController {

      @Autowired
     private BookRepository bookRepository;

       @Autowired
      private AuthorRepository authorRepository;
     @GetMapping("/name/{name}")
    public  String displayName(@PathVariable("name") String name)
    {
         return  "Hello " + name;
    }


    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {

        Set<Author> authors = book.getAuthors();

        // Save each new author to the database
        for (Author author : authors) {
            if (author.getId() == null) {
                authorRepository.save(author);
            }
            author.getBooks().add(book); // add the book to the author's set of books
        }

        // Save the book to the database
        Book savedBook = bookRepository.save(book);

        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }


}
