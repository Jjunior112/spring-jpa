package com.bookstore.spring_JPA.controllers;

import org.springframework.stereotype.Controller;

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

    public String create(@RequestBody ReviewRecordDto reviewDto)
    {
        return reviewService.create(reviewDto);
    }

    @DeleteMapping("/{id}")

    public String delete(@PathVariable UUID id)
    {

        var response =reviewService.delete(id);
    
        return response.message();
    }


    



}
