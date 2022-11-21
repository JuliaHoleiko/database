package com.holeiko.database.service.impl;

import com.holeiko.database.dao.MotorDao;
import com.holeiko.database.domain.Motor;
import com.holeiko.database.service.MotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MotorServiceImpl implements MotorService {

    @Autowired
    private MotorDao motorDao;
    @Override
    public List<Motor> findAll() {
        return motorDao.findAll();
    }

    @Override
    public Optional<Motor> findById(Integer integer) {
        return motorDao.findById(integer);
    }

    @Override
    public int create(Motor entity) {
        return motorDao.create(entity);
    }

    @Override
    public int update(Integer integer, Motor entity) {
        return motorDao.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return motorDao.delete(integer);
    }
}
