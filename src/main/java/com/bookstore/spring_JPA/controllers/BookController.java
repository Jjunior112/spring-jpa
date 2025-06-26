package com.bookstore.spring_JPA.controllers;

import com.bookstore.spring_JPA.dtos.BookRecordDto;
import com.bookstore.spring_JPA.dtos.DeleteResponse;
import com.bookstore.spring_JPA.models.Book;
import com.bookstore.spring_JPA.services.BookService;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/book")

public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @PostMapping

    public Book create(@RequestBody BookRecordDto bookDto)
    {
        return bookService.create(bookDto);
    }

    @GetMapping
    public List<Book> getAll()
    {
        return bookService.findAll();
    }

    @GetMapping("/{id}")

    public Book getById(@PathVariable UUID id)
    {
        return bookService.findById(id);
    }

    @DeleteMapping("/{id}")
    
    public String delete(@PathVariable UUID id)
    {
        DeleteResponse response = bookService.delete(id);

        return response.message();
    }

}
