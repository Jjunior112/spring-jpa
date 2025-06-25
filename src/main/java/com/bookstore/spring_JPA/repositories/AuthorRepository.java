package com.bookstore.spring_JPA.repositories;

import com.bookstore.spring_JPA.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    Author findAuthorByName(String name); 

    long countByAuthorId(UUID authorId);
}
