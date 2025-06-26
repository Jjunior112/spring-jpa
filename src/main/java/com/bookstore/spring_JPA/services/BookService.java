package com.bookstore.spring_JPA.services;

import com.bookstore.spring_JPA.dtos.BookRecordDto;
import com.bookstore.spring_JPA.dtos.DeleteResponse;
import com.bookstore.spring_JPA.exceptions.ResourceNotFoundException;
import com.bookstore.spring_JPA.models.Book;
import com.bookstore.spring_JPA.models.Publisher;
import com.bookstore.spring_JPA.models.Review;
import com.bookstore.spring_JPA.repositories.AuthorRepository;
import com.bookstore.spring_JPA.repositories.BookRepository;
import com.bookstore.spring_JPA.repositories.PublisherRepository;
import com.bookstore.spring_JPA.repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class BookService {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final ReviewRepository reviewRepository;

    public BookService(BookRepository bookRepository, PublisherRepository publisherRepository, AuthorRepository authorRepository, ReviewRepository reviewRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.reviewRepository = reviewRepository;
    }

    @Transactional
    public Book create(BookRecordDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.title());

        Publisher publisher = publisherRepository.findById(bookDto.publisherId())
                .orElseThrow(() -> new ResourceNotFoundException("Editora não encontrada com ID: " + bookDto.publisherId()));
        book.setPublisher(publisher);

        var authors = authorRepository.findAllById(bookDto.authorsIds());
        if (authors.size() != bookDto.authorsIds().size()) {
            throw new ResourceNotFoundException("Um ou mais autores não foram encontrados.");
        }
        book.setAuthors(new HashSet<>(authors));

        Review review = new Review();
        review.setComment(bookDto.reviewComment());
        review.setBook(book);
        book.setReview(review);

        reviewRepository.save(review);

        return bookRepository.save(book);
    }
    public List<Book> findAll() {

        return bookRepository.findAll();
    }

    public Book findById(UUID id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livro com id: " + id + " não encontrado!"));
    }

    public DeleteResponse delete(UUID id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro com id: " + id + " não encontrado!"));

        bookRepository.delete(book);

        return new DeleteResponse(true, "Livro deletado com sucesso!");
    }

}
