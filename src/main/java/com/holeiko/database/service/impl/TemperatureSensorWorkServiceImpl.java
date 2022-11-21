package com.holeiko.database.service.impl;

import com.holeiko.database.dao.TemperatureSensorWorkDao;
import com.holeiko.database.dao.impl.LightSensorWorkDaoImpl;
import com.holeiko.database.domain.LightSensorWork;
import com.holeiko.database.domain.TemperatureSensorWork;
import com.holeiko.database.service.LightSensorWorkService;
import com.holeiko.database.service.TemperatureSensorWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemperatureSensorWorkServiceImpl implements TemperatureSensorWorkService {
    @Autowired
    private TemperatureSensorWorkDao sensorWorkDao;

    @Override
    public List<TemperatureSensorWork> findAll() {
        return sensorWorkDao.findAll();
    }

    @Override
    public Optional<TemperatureSensorWork> findById(Integer integer) {
        return sensorWorkDao.findById(integer);
    }

    @Override
    public int create(TemperatureSensorWork entity) {
        return sensorWorkDao.create(entity);
    }

    @Override
    public int update(Integer integer, TemperatureSensorWork entity) {
        return sensorWorkDao.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return sensorWorkDao.delete(integer);
    }
}
