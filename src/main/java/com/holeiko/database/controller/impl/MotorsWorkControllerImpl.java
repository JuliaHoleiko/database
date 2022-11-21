package com.holeiko.database.controller.impl;

import com.holeiko.database.controller.LightSensorWorkController;
import com.holeiko.database.controller.MotorsWorkController;
import com.holeiko.database.domain.LightSensorWork;
import com.holeiko.database.domain.MotorsWork;
import com.holeiko.database.service.MoistureSensorWorkService;
import com.holeiko.database.service.MotorsWorkService;
import com.holeiko.database.service.impl.LightSensorWorkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorsWorkControllerImpl implements MotorsWorkController {

    @Autowired
    private MotorsWorkService motorsWorkService;
    @Override
    public List<MotorsWork> findAll() {
        return motorsWorkService.findAll();
    }

    @Override
    public Optional<MotorsWork> findById(Integer integer) {
        return motorsWorkService.findById(integer);
    }

    @Override
    public int create(MotorsWork entity) {
        return motorsWorkService.create(entity);
    }

    @Override
    public int update(Integer integer, MotorsWork entity) {
        return motorsWorkService.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return motorsWorkService.delete(integer);
    }
}
