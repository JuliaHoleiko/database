package com.holeiko.lab5.exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(Integer id){
        super("Could not find 'Client' with id=" + id);
    }

}
