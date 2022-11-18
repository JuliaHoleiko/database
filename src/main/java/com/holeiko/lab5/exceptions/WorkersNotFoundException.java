package com.holeiko.lab5.exceptions;

public class WorkersNotFoundException extends RuntimeException{
    public WorkersNotFoundException(Integer id) {
        super("Could not find 'Water System' with id=" + id);
    }
}
