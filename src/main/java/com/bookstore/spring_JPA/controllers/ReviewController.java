package com.bookstore.spring_JPA.controllers;

import com.bookstore.spring_JPA.dtos.DeleteResponse;
import com.bookstore.spring_JPA.dtos.ReviewRecordDto;
import com.bookstore.spring_JPA.models.Review;
import com.bookstore.spring_JPA.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/review")

public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService)
    {
        this.reviewService = reviewService;
    }

    @GetMapping

    public List<Review> getAll()
    {
        return reviewService.findAll();
    }
    

    @GetMapping("/{id}")
    
    public Optional<Review> getById(@PathVariable UUID id)
    {

        return reviewService.findById(id);
    
    }

    @PostMapping

    public Review create(@RequestBody ReviewRecordDto reviewDto)
    {
        return reviewService.create(reviewDto);
    }

    @DeleteMapping("/{id}")

    public String delete(@PathVariable UUID id)
    {

        DeleteResponse response =reviewService.delete(id);
    
        return response.message();
    }


    



}
