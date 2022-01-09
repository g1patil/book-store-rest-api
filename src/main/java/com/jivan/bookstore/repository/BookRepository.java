package com.jivan.bookstore.repository;

import com.jivan.bookstore.model.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findById(@NotBlank Long id);
    List<Book> findAll();
    Book save(Book book);
}
