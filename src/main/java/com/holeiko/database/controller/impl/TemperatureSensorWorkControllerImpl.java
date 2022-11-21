package com.holeiko.database.controller.impl;

import com.holeiko.database.controller.MoistureSensorWorkController;
import com.holeiko.database.controller.TemperatureSensorWorkController;
import com.holeiko.database.domain.MoistureSensorWork;
import com.holeiko.database.domain.TemperatureSensorWork;
import com.holeiko.database.service.MoistureSensorWorkService;
import com.holeiko.database.service.TemperatureSensorWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemperatureSensorWorkControllerImpl implements TemperatureSensorWorkController {

    @Autowired
    private TemperatureSensorWorkService sensorWorkService;
    @Override
    public List<TemperatureSensorWork> findAll() {
        return sensorWorkService.findAll();
    }

    @Override
    public Optional<TemperatureSensorWork> findById(Integer integer) {
        return sensorWorkService.findById(integer);
    }

    @Override
    public int create(TemperatureSensorWork entity) {
        return sensorWorkService.create(entity);
    }

    @Override
    public int update(Integer integer, TemperatureSensorWork entity) {
        return sensorWorkService.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return sensorWorkService.delete(integer);
    }
}
