package com.bookstore.spring_JPA.services;

import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository,BookRepository bookRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author create(Author author)
    {
        return authorRepository.save(author);
    }

    public List<Author> findAll()
    {
        return authorRepository.findAll();
    }

    public Author findById(UUID id)
    {
        return authorRepository.findById(id);
    }

    public void delete(UUID id)
    {
        Author author = authorRepository.findById(id).orElseThrow() -> new ResourceNotFoundException("Autor não encontrado com id " + id);
        
        if(bookRepository.countByAuthorId>0)
        {
            throw new DeletionException("Não é possível excluir autor.Existem livros associados.");
        }   

        return authorRepository.delete(author);

    }

}
