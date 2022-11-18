package com.holeiko.lab5.exceptions;

public class LoggerNotFoundException  extends RuntimeException{
    public LoggerNotFoundException(Integer id){
        super("Could not find 'Logger' with id=" + id);
    }
}
