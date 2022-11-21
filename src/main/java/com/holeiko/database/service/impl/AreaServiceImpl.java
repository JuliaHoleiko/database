package com.holeiko.database.service.impl;

import com.holeiko.database.dao.AreaDao;
import com.holeiko.database.domain.Area;
import com.holeiko.database.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;


    @Override
    public List<Area> findByOwnerSurname(Integer ownerSurname) {
        return areaDao.findByOwnerSurname(ownerSurname);
    }

    @Override
    public List<Area> findAll() {
        return areaDao.findAll();
    }

    @Override
    public Optional<Area> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public int create(Area entity) {
        return areaDao.create(entity);
    }

    @Override
    public int update(Integer integer, Area entity) {
        return areaDao.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return areaDao.delete(integer);
    }
}
