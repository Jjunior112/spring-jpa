package com.bookstore.spring_JPA.controllers;

import com.bookstore.spring_JPA.dtos.DeleteResponse;
import com.bookstore.spring_JPA.dtos.PublisherRecordDto;
import com.bookstore.spring_JPA.models.Publisher;
import com.bookstore.spring_JPA.services.PublisherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("publisher")

public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService)
    {
        this.publisherService = publisherService;

    }

    @GetMapping

    public List<Publisher> getAll()
    {
        return publisherService.findAll();
    }

    @GetMapping("/{id}")

    public Publisher getById(@PathVariable UUID id)
    {
        return publisherService.findById(id);
    }

    @PostMapping

    public Publisher create(@RequestBody PublisherRecordDto publisherDto)
    {
        return publisherService.create(publisherDto);
    }

    @DeleteMapping("/{id}")

    public String delete(@PathVariable UUID id)
    {
        DeleteResponse response = publisherService.delete(id);
        
        return response.message();
    }

}
