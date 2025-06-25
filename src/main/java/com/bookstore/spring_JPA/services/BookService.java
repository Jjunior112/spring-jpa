package com.bookstore.spring_JPA.services;

import com.bookstore.spring_JPA.dtos.BookRecordDto;
import com.bookstore.spring_JPA.exceptions.ResourceNotFoundException;
import com.bookstore.spring_JPA.models.Book;
import com.bookstore.spring_JPA.repositories.AuthorRepository;
import com.bookstore.spring_JPA.repositories.BookRepository;
import com.bookstore.spring_JPA.repositories.PublisherRepository;
import com.bookstore.spring_JPA.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final ReviewRepository reviewRepository;

    public BookService(BookRepository bookRepository,PublisherRepository publisherRepository,AuthorRepository authorRepository, ReviewRepository reviewRepository)
    {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.reviewRepository = reviewRepository;
    }

    public Book create(BookRecordDto bookDto)
    {
        Book book = new Book();

        book.setTitle(bookDto.title());

        return bookRepository.save(book);
    } 

    public List<Book> findAll()
    {
        return bookRepository.findAll();
    }

    public Book findById(UUID id)
    {
        return bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Livro com id: " + id + " não encontrado!"));
    }

    public void delete(UUID id)
    {
        Book book = bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Livro com id: " + id + " não encontrado!"));    

        bookRepository.delete(book);
    }

}
