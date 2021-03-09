package com.codecool.exception;


public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Class<?> clazz, Long id) {
        super(String.format("Could not find %s with id %d", clazz.getSimpleName(), id));
    }
}