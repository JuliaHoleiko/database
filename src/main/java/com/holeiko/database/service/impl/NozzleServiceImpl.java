package com.holeiko.database.service.impl;

import com.holeiko.database.dao.NozzleDao;
import com.holeiko.database.domain.Nozzle;
import com.holeiko.database.service.NozzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NozzleServiceImpl implements NozzleService {
    @Autowired
    private NozzleDao nozzleDao;

    @Override
    public List<Nozzle> findAll() {
        return nozzleDao.findAll();
    }

    @Override
    public Optional<Nozzle> findById(Integer integer) {
        return nozzleDao.findById(integer);
    }

    @Override
    public int create(Nozzle entity) {
        return nozzleDao.create(entity);
    }

    @Override
    public int update(Integer integer, Nozzle entity) {
        return nozzleDao.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return nozzleDao.delete(integer);
    }
}
