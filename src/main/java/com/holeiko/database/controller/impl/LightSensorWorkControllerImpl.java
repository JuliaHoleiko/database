package com.holeiko.database.controller.impl;

import com.holeiko.database.controller.LightSensorWorkController;
import com.holeiko.database.domain.LightSensorWork;
import com.holeiko.database.service.impl.LightSensorWorkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LightSensorWorkControllerImpl implements LightSensorWorkController {

    @Autowired
    private LightSensorWorkServiceImpl sensorWorkService;
    @Override
    public List<LightSensorWork> findAll() {
        return sensorWorkService.findAll();
    }

    @Override
    public Optional<LightSensorWork> findById(Integer integer) {
        return sensorWorkService.findById(integer);
    }

    @Override
    public int create(LightSensorWork entity) {
        return sensorWorkService.create(entity);
    }

    @Override
    public int update(Integer integer, LightSensorWork entity) {
        return sensorWorkService.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return sensorWorkService.delete(integer);
    }
}
