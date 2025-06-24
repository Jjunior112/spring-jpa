package com.bookstore.spring_JPA.repositories;

import com.bookstore.spring_JPA.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {

}
