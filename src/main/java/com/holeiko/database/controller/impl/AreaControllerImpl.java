package com.holeiko.database.controller.impl;

import com.holeiko.database.controller.AreaController;
import com.holeiko.database.domain.Area;
import com.holeiko.database.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaControllerImpl implements AreaController {

    @Autowired
    private AreaService areaService;

    @Override
    public List<Area> findByOwnerSurname(Integer ownerSurname) {
        return areaService.findByOwnerSurname(ownerSurname);
    }

    @Override
    public List<Area> findAll() {
        return areaService.findAll();
    }

    @Override
    public Optional<Area> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public int create(Area entity) {
        return areaService.create(entity);
    }

    @Override
    public int update(Integer integer, Area entity) {
        return areaService.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return areaService.delete(integer);
    }
}
