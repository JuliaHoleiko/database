package com.holeiko.database.service.impl;

import com.holeiko.database.dao.impl.LightSensorWorkDaoImpl;
import com.holeiko.database.domain.LightSensorWork;
import com.holeiko.database.service.LightSensorWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LightSensorWorkServiceImpl implements LightSensorWorkService {
    @Autowired
    private LightSensorWorkDaoImpl sensorWorkDao;

    @Override
    public List<LightSensorWork> findAll() {
        return sensorWorkDao.findAll();
    }

    @Override
    public Optional<LightSensorWork> findById(Integer integer) {
        return sensorWorkDao.findById(integer);
    }

    @Override
    public int create(LightSensorWork entity) {
        return sensorWorkDao.create(entity);
    }

    @Override
    public int update(Integer integer, LightSensorWork entity) {
        return sensorWorkDao.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return sensorWorkDao.delete(integer);
    }
}
