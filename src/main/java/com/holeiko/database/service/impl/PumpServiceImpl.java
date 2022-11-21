package com.holeiko.database.service.impl;

import com.holeiko.database.dao.PumpDao;
import com.holeiko.database.domain.Pump;
import com.holeiko.database.service.PumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PumpServiceImpl implements PumpService {
    @Autowired
    private PumpDao pumpDao;

    @Override
    public List<Pump> findAll() {
        return pumpDao.findAll();
    }

    @Override
    public Optional<Pump> findById(Integer integer) {
        return pumpDao.findById(integer);
    }

    @Override
    public int create(Pump entity) {
        return pumpDao.create(entity);
    }

    @Override
    public int update(Integer integer, Pump entity) {
        return pumpDao.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return pumpDao.delete(integer);
    }
}
