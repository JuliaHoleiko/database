package com.holeiko.database.controller.impl;

import com.holeiko.database.controller.LightSensorWorkController;
import com.holeiko.database.controller.MoistureSensorWorkController;
import com.holeiko.database.domain.LightSensorWork;
import com.holeiko.database.domain.MoistureSensorWork;
import com.holeiko.database.service.MoistureSensorWorkService;
import com.holeiko.database.service.impl.LightSensorWorkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoistureSensorWorkControllerImpl implements MoistureSensorWorkController {

    @Autowired
    private MoistureSensorWorkService sensorWorkService;
    @Override
    public List<MoistureSensorWork> findAll() {
        return sensorWorkService.findAll();
    }

    @Override
    public Optional<MoistureSensorWork> findById(Integer integer) {
        return sensorWorkService.findById(integer);
    }

    @Override
    public int create(MoistureSensorWork entity) {
        return sensorWorkService.create(entity);
    }

    @Override
    public int update(Integer integer, MoistureSensorWork entity) {
        return sensorWorkService.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return sensorWorkService.delete(integer);
    }
}
