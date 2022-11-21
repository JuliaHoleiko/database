package com.holeiko.database.controller.impl;

import com.holeiko.database.controller.WaterSystemController;
import com.holeiko.database.domain.WaterSystem;
import com.holeiko.database.service.WaterSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class WaterSystemControllerImpl implements WaterSystemController {
    @Autowired
    private WaterSystemService waterSystemService;


    @Override
    public List<WaterSystem> findAll() {
        return waterSystemService.findAll();
    }

    @Override
    public Optional<WaterSystem> findById(Integer integer) {
        return waterSystemService.findById(integer);
    }

    @Override
    public int create(WaterSystem entity) {
        return waterSystemService.create(entity);
    }

    @Override
    public int update(Integer integer, WaterSystem entity) {
        return waterSystemService.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return waterSystemService.delete(integer);
    }
}
