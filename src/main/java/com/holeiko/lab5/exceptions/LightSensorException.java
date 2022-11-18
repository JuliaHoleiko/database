package com.holeiko.lab5.exceptions;

public class LightSensorException extends RuntimeException {
    public LightSensorException(Integer id) {
        super("Could not find 'Client' with id=" + id);
    }
}

