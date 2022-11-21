package com.holeiko.database.controller.impl;

import com.holeiko.database.controller.SensorController;
import com.holeiko.database.domain.Sensor;
import com.holeiko.database.service.impl.LightSensorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LightSensorControllerImpl implements SensorController {
    @Autowired
    private LightSensorServiceImpl lightSensorService;
    @Override
    public List<Sensor> findAll() {
        return lightSensorService.findAll();
    }

    @Override
    public Optional<Sensor> findById(Integer integer) {
        return lightSensorService.findById(integer);
    }

    @Override
    public int create(Sensor entity) {
        return lightSensorService.create(entity);
    }

    @Override
    public int update(Integer integer, Sensor entity) {
        return lightSensorService.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return lightSensorService.delete(integer);
    }
}
