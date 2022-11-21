package com.holeiko.database.controller.impl;

import com.holeiko.database.controller.MotorController;
import com.holeiko.database.domain.Motor;
import com.holeiko.database.service.MotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MotorControllerImpl implements MotorController {
    @Autowired
    private MotorService motorService;
    @Override
    public List<Motor> findAll() {
        return motorService.findAll();
    }

    @Override
    public Optional<Motor> findById(Integer integer) {
        return motorService.findById(integer);
    }

    @Override
    public int create(Motor entity) {
        return motorService.create(entity);
    }

    @Override
    public int update(Integer integer, Motor entity) {
        return motorService.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return motorService.delete(integer);
    }
}
