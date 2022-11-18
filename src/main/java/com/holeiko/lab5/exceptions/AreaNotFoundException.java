package com.holeiko.lab5.exceptions;

public class AreaNotFoundException extends RuntimeException{
    public AreaNotFoundException(Integer id){
        super("Could not find 'Area' with id=" + id);
    }

}
