package com.bookstore.spring_JPA.exceptions;

public class DeletionException extends RuntimeException{

    public DeletionException(String message)
    {
        super(message);
    }
}
