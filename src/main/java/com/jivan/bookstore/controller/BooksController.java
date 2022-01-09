package com.jivan.bookstore.controller;


import com.jivan.bookstore.model.Book;
import com.jivan.bookstore.payload.BookRequest;
import com.jivan.bookstore.payload.BookResponse;
import com.jivan.bookstore.service.BookService;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Data
@RestController
@RequestMapping(path = "api/v1/books")
@ResponseBody
public class BooksController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> getAlbum(@PathVariable(name = "id") Long id) {
        Book book =  bookService.getBook(id);
        return new ResponseEntity(book, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Book> getAllBooks() {
        List<Book> books =  bookService.getAllBooks();
        return new ResponseEntity(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody BookRequest bookRequest) {
        Book newBook =  bookService.createBook(bookRequest);
        return new ResponseEntity(newBook, HttpStatus.CREATED);
    }

    @PutMapping(value =  "/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(name = "id") Long id, @Valid @RequestBody BookRequest bookRequest) {
        Book newBook =  bookService.updateBook(id , bookRequest);
        return new ResponseEntity(newBook, HttpStatus.OK);
    }

}
