package com.holeiko.database.service.impl;

import com.holeiko.database.dao.AreaDao;
import com.holeiko.database.dao.ClientDao;
import com.holeiko.database.domain.Area;
import com.holeiko.database.domain.Client;
import com.holeiko.database.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;


    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Optional<Client> findById(Integer integer) {
        return clientDao.findById(integer);
    }

    @Override
    public int create(Client entity) {
        return clientDao.create(entity);
    }

    @Override
    public int update(Integer integer, Client entity) {
        return clientDao.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return clientDao.delete(integer);
    }
}
