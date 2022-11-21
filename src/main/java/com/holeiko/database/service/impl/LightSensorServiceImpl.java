package com.holeiko.database.service.impl;

import com.holeiko.database.dao.impl.LightSensorDaoImpl;
import com.holeiko.database.domain.Sensor;
import com.holeiko.database.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LightSensorServiceImpl implements SensorService {
    @Autowired
    private LightSensorDaoImpl lightSensorDao;

    @Override
    public List<Sensor> findAll() {
        return lightSensorDao.findAll();
    }

    @Override
    public Optional<Sensor> findById(Integer integer) {
        return lightSensorDao.findById(integer);
    }

    @Override
    public int create(Sensor entity) {
        return lightSensorDao.create(entity);
    }

    @Override
    public int update(Integer integer, Sensor entity) {
        return lightSensorDao.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return lightSensorDao.delete(integer);
    }
}
