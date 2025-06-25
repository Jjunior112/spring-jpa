package com.bookstore.spring_JPA.services;

import org.springframework.stereotype.Service;

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
