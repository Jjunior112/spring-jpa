package com.bookstore.spring_JPA.controllers;

import org.springframework.stereotype.Controller;


import java.util.Optional;


@RestController
@RequestMapping("/book")

public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @PostMapping

    public String create(@RequestBody BookRecordDto bookDto)
    {
        return bookService.create(bookDto);
    }

    @GetMapping
    public List<Book> getAll()
    {
        return authorService.findAll();
    }

    @GetMapping("/{id}")

    public Optional<Book> getById(@PathVariable UUID id)
    {
        bookService.findById(id);
    }

    @DeleteMapping("/{id}")
    
    public String delete(@PathVariable UUID id)
    {
        var response = bookService.delete(id);

        return response.message();
    }

}
