package com.jivan.bookstore.service;

import com.jivan.bookstore.model.Book;
import com.jivan.bookstore.payload.BookRequest;

import java.util.List;

public interface BookService {

    Book getBook(Long id);
    Book createBook(BookRequest bookRequest);
    Book updateBook(Long id , BookRequest bookRequest);
    List<Book> getAllBooks();
    List<String> validateBookInventory(Long id ,  int count);

}
