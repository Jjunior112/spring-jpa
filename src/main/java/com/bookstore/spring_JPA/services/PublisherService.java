package com.bookstore.spring_JPA.services;

import com.bookstore.spring_JPA.dtos.PublisherRecordDto;
import com.bookstore.spring_JPA.models.Publisher;
import com.bookstore.spring_JPA.repositories.PublisherRepository;
import com.bookstore.spring_JPA.repositories.BookRepository;
import com.bookstore.spring_JPA.exceptions.ResourceNotFoundException;
import com.bookstore.spring_JPA.exceptions.DeletionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final BookRepository bookRepository;

    public PublisherService(PublisherRepository publisherRepository, BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }



    public String create(PublisherRecordDto publisherDto) {

        Publisher publisher = new Publisher();

        publisher.setName(publisherDto.name());

        publisherRepository.save(publisher);

        return new publisherRecordDto(saved.getName());

    }
  
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    public Optional<Publisher> findById(UUID id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Editora não encontrada com ID: " + id));
    }
    
    public DeleteResponse delete(UUID id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Editora não encontrada com ID: " + id));

        if (bookRepository.countByPublisherId(id) > 0) {
            throw new DeletionException("Não é possível excluir a editora. Existem livros associados.");
        }

        publisherRepository.delete(publisher);

        return new DeleteResponse(true,"Editora deletado com sucesso!");
    }
}
