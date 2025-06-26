package com.bookstore.spring_JPA.services;

import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    public ReviewService(BookRepository bookRepository, ReviewRepository reviewRepository)
    {
        this.bookRepository = bookRepository;
        this.reviewRepository = reviewRepository;
    }

    public String create(ReviewRecordDto reviewDto)
    {
        Review review = new Review();

        review.setComment(reviewDto.comment());

        reviewRepository.save(review);

        return new ReviewRecordDto(saved.getName());

    }

    public List<Review> findAll()
    {

        return reviewRepository.findAll();

    }

    public Optional<Review> findById(UUID id)
    {
        return reviewRepository.findById(id);
    }

    public DeleteResponse delete(UUID id)
    {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new DeletionException("Comentário não encontrado com id " + id));

        if (bookRepository.countByReviewId(id) > 0) {
           return new DeleteResponse(false," Não é possível excluir comentário.Existem livros associados!");
        }

        reviewRepository.delete(review);

        return new DeleteResponse(true,"Comentário deletado com sucesso!");

    }


}
