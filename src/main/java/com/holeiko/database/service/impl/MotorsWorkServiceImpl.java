package com.holeiko.database.service.impl;

import com.holeiko.database.dao.MoistureSensorWorkDao;
import com.holeiko.database.dao.MotorsWorkDao;
import com.holeiko.database.domain.MoistureSensorWork;
import com.holeiko.database.domain.MotorsWork;
import com.holeiko.database.service.MoistureSensorWorkService;
import com.holeiko.database.service.MotorsWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorsWorkServiceImpl implements MotorsWorkService {
    @Autowired
    private MotorsWorkDao motorsWorkDao;

    @Override
    public List<MotorsWork> findAll() {
        return motorsWorkDao.findAll();
    }

    @Override
    public Optional<MotorsWork> findById(Integer integer) {
        return motorsWorkDao.findById(integer);
    }

    @Override
    public int create(MotorsWork entity) {
        return motorsWorkDao.create(entity);
    }

    @Override
    public int update(Integer integer, MotorsWork entity) {
        return motorsWorkDao.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return motorsWorkDao.delete(integer);
    }
}
