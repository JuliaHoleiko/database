package com.holeiko.database.service.impl;

import com.holeiko.database.dao.MoistureSensorWorkDao;
import com.holeiko.database.dao.impl.LightSensorWorkDaoImpl;
import com.holeiko.database.domain.LightSensorWork;
import com.holeiko.database.domain.MoistureSensorWork;
import com.holeiko.database.service.LightSensorWorkService;
import com.holeiko.database.service.MoistureSensorWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoistureSensorWorkServiceImpl implements MoistureSensorWorkService {
    @Autowired
    private MoistureSensorWorkDao sensorWorkDao;

    @Override
    public List<MoistureSensorWork> findAll() {
        return sensorWorkDao.findAll();
    }

    @Override
    public Optional<MoistureSensorWork> findById(Integer integer) {
        return sensorWorkDao.findById(integer);
    }

    @Override
    public int create(MoistureSensorWork entity) {
        return sensorWorkDao.create(entity);
    }

    @Override
    public int update(Integer integer, MoistureSensorWork entity) {
        return sensorWorkDao.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return sensorWorkDao.delete(integer);
    }
}
