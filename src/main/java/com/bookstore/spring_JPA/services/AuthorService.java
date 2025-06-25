package com.bookstore.spring_JPA.services;

import com.bookstore.spring_JPA.dtos.AuthorRecordDto;
import com.bookstore.spring_JPA.dtos.DeleteResponse;
import com.bookstore.spring_JPA.exceptions.DeletionException;
import com.bookstore.spring_JPA.exceptions.ResourceNotFoundException;
import com.bookstore.spring_JPA.models.Author;
import com.bookstore.spring_JPA.repositories.AuthorRepository;
import com.bookstore.spring_JPA.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public AuthorRecordDto create(AuthorRecordDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.name());
        Author saved = authorRepository.save(author);
        return new AuthorRecordDto(saved.getName());
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> findById(UUID id) {

        return authorRepository.findById(id);
    }

    public DeleteResponse delete(UUID id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new DeletionException("Autor não encontrado com id " + id));

        if (bookRepository.countByAuthorsId(id) > 0) {
           return new DeleteResponse(false," Não é possível excluir autor.Existem livros associados!");
        }

        authorRepository.delete(author);

        return new DeleteResponse(true,"Autor deletado com sucesso!");

    }

}
