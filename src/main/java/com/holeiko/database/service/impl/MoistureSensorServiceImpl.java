package com.holeiko.database.service.impl;

import com.holeiko.database.dao.impl.LightSensorDaoImpl;
import com.holeiko.database.dao.impl.MoistureSensorDaoImpl;
import com.holeiko.database.domain.Sensor;
import com.holeiko.database.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MoistureSensorServiceImpl implements SensorService {

    @Autowired
    private MoistureSensorDaoImpl moistureSensorDao;

    @Override
    public List<Sensor> findAll() {
        return moistureSensorDao.findAll();
    }

    @Override
    public Optional<Sensor> findById(Integer integer) {
        return moistureSensorDao.findById(integer);
    }

    @Override
    public int create(Sensor entity) {
        return moistureSensorDao.create(entity);
    }

    @Override
    public int update(Integer integer, Sensor entity) {
        return moistureSensorDao.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return moistureSensorDao.delete(integer);
    }
}
