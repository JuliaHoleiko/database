package com.holeiko.database.controller.impl;

import com.holeiko.database.controller.PumpController;
import com.holeiko.database.domain.Pump;
import com.holeiko.database.service.PumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PumpControllerImpl implements PumpController {
    @Autowired
    private PumpService pumpService;
    @Override
    public List<Pump> findAll() {
        return pumpService.findAll();
    }

    @Override
    public Optional<Pump> findById(Integer integer) {
        return pumpService.findById(integer);
    }

    @Override
    public int create(Pump entity) {
        return pumpService.create(entity);
    }

    @Override
    public int update(Integer integer, Pump entity) {
        return pumpService.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return pumpService.delete(integer);
    }
}
