package com.holeiko.database.service.impl;

import com.holeiko.database.dao.WaterSystemDao;
import com.holeiko.database.domain.WaterSystem;
import com.holeiko.database.service.WaterSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class WaterSystemServiceImpl implements WaterSystemService {
    @Autowired
    private WaterSystemDao waterSystemDao;

    @Override
    public List<WaterSystem> findAll() {
        return waterSystemDao.findAll();
    }

    @Override
    public Optional<WaterSystem> findById(Integer integer) {
        return waterSystemDao.findById(integer);
    }

    @Override
    public int create(WaterSystem entity) {
        return waterSystemDao.create(entity);
    }

    @Override
    public int update(Integer integer, WaterSystem entity) {
        return waterSystemDao.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return waterSystemDao.delete(integer);
    }
}
