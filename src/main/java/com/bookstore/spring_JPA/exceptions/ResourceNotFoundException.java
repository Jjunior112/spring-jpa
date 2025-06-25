package com.bookstore.spring_JPA.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message)
    {
        super(message);
    }

}
