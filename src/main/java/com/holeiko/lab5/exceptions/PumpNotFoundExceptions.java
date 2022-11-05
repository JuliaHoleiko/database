package com.holeiko.lab5.exceptions;

public class PumpNotFoundExceptions   extends RuntimeException{
        public PumpNotFoundExceptions(Integer id){
            super("Could not find 'Pump' with id=" + id);
        }
}
