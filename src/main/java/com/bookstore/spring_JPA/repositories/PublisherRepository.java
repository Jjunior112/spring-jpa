package com.bookstore.spring_JPA.repositories;

import com.bookstore.spring_JPA.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<Publisher, UUID> {

}
