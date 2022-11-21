package com.holeiko.database.controller.impl;

import com.holeiko.database.controller.SensorController;
import com.holeiko.database.domain.Sensor;
import com.holeiko.database.service.impl.LightSensorServiceImpl;
import com.holeiko.database.service.impl.MoistureSensorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MoistureSensorControllerImpl implements SensorController {
    @Autowired
    private MoistureSensorServiceImpl moistureSensorService;
    @Override
    public List<Sensor> findAll() {
        return moistureSensorService.findAll();
    }

    @Override
    public Optional<Sensor> findById(Integer integer) {
        return moistureSensorService.findById(integer);
    }

    @Override
    public int create(Sensor entity) {
        return moistureSensorService.create(entity);
    }

    @Override
    public int update(Integer integer, Sensor entity) {
        return moistureSensorService.update(integer,entity);
    }

    public int delete(Integer integer) {
        return moistureSensorService.delete(integer);
    }
}
