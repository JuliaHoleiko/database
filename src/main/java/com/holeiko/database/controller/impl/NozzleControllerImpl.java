package com.holeiko.database.controller.impl;

import com.holeiko.database.controller.NozzleController;
import com.holeiko.database.domain.Nozzle;
import com.holeiko.database.service.NozzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NozzleControllerImpl implements NozzleController {
    @Autowired
    private NozzleService nozzleService;

    @Override
    public List<Nozzle> findAll() {
        return nozzleService.findAll();
    }

    @Override
    public Optional<Nozzle> findById(Integer integer) {
        return nozzleService.findById(integer);
    }

    @Override
    public int create(Nozzle entity) {
        return nozzleService.create(entity);
    }

    @Override
    public int update(Integer integer, Nozzle entity) {
        return nozzleService.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return nozzleService.delete(integer);
    }
}
