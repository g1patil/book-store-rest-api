package com.jivan.bookstore.service.impl;

import com.jivan.bookstore.exception.BookException;
import com.jivan.bookstore.model.Book;
import com.jivan.bookstore.payload.BookRequest;
import com.jivan.bookstore.repository.BookRepository;
import com.jivan.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(()->new BookException("Book not found"));
    }

    @Override
    public Book createBook(BookRequest bookRequest) {
        Book newBook = new Book();
        newBook.setName(bookRequest.getName());
        newBook.setAuthorName(bookRequest.getAuthorName());
        return bookRepository.save(newBook);
    }

    @Override
    public Book updateBook(Long id , BookRequest bookRequest) {
        Book book = bookRepository.findById(id).orElseThrow(()->new BookException("Book not found"));
        book.setName(bookRequest.getName());
        book.setAuthorName(bookRequest.getAuthorName());
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<String> validateBookInventory(Long id, int count) {
        List<String> errors = new ArrayList<>();
        Book book = bookRepository.getById(id);
        int currentStockCount = book.getBookInventory().getAvailableCount();
        if (currentStockCount == 0 ) {
            errors.add("We are currently out of stock for the book " + book.getName());
        } else if ( count > book.getBookInventory().getAvailableCount()){
            errors.add("We have less stock for the book " + book.getName() + " . Consider editing your order");
        }
        return errors;
    }

}
