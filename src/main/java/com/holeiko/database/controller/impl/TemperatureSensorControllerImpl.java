package com.holeiko.database.controller.impl;

import com.holeiko.database.controller.SensorController;
import com.holeiko.database.domain.Sensor;
import com.holeiko.database.service.impl.MoistureSensorServiceImpl;
import com.holeiko.database.service.impl.TemperatureSensorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TemperatureSensorControllerImpl implements SensorController {
    @Autowired
    private TemperatureSensorServiceImpl temperatureSensorService;
    @Override
    public List<Sensor> findAll() {
        return temperatureSensorService.findAll();
    }

    @Override
    public Optional<Sensor> findById(Integer integer) {
        return temperatureSensorService.findById(integer);
    }

    @Override
    public int create(Sensor entity) {
        return temperatureSensorService.create(entity);
    }

    @Override
    public int update(Integer integer, Sensor entity) {
        return temperatureSensorService.update(integer,entity);
    }

    public int delete(Integer integer) {
        return temperatureSensorService.delete(integer);
    }
}
