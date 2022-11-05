package com.holeiko.lab5.exceptions;

public class WaterSystemNotFoundException extends RuntimeException{
    public WaterSystemNotFoundException(Integer id){
        super("Could not find 'Water System' with id=" + id);
    }
}
