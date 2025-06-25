package com.bookstore.spring_JPA.controllers;

import com.bookstore.spring_JPA.dtos.AuthorRecordDto;
import com.bookstore.spring_JPA.dtos.DeleteResponse;
import com.bookstore.spring_JPA.models.Author;
import com.bookstore.spring_JPA.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService)
    {
        this.authorService = authorService;
    }

    @GetMapping

    public List<Author> getAll()
    {
        return authorService.findAll();
    }

    @GetMapping("/{id}")

    public Optional<Author> getById(@PathVariable UUID id)
    {
        return authorService.findById(id);
    }

    @PostMapping

        public AuthorRecordDto create(@RequestBody AuthorRecordDto authorDto)
        {

            return authorService.create(authorDto);


        }

        @DeleteMapping("/{id}")

        public String delete(@PathVariable UUID id)

        {
            var response = authorService.delete(id);

             return response.message();
        }



}
