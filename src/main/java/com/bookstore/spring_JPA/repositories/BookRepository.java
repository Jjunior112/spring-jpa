package com.bookstore.spring_JPA.repositories;

import com.bookstore.spring_JPA.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

    Book findBookByTitle(String title);


}
