package com.holeiko.database.service.impl;

import com.holeiko.database.dao.impl.LightSensorDaoImpl;
import com.holeiko.database.dao.impl.TemperatureSensorDaoImpl;
import com.holeiko.database.domain.Sensor;
import com.holeiko.database.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TemperatureSensorServiceImpl implements SensorService {
    @Autowired
    private TemperatureSensorDaoImpl temperatureSensorDao;

    @Override
    public List<Sensor> findAll() {
        return temperatureSensorDao.findAll();
    }

    @Override
    public Optional<Sensor> findById(Integer integer) {
        return temperatureSensorDao.findById(integer);
    }

    @Override
    public int create(Sensor entity) {
        return temperatureSensorDao.create(entity);
    }

    @Override
    public int update(Integer integer, Sensor entity) {
        return temperatureSensorDao.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return temperatureSensorDao.delete(integer);
    }
}
