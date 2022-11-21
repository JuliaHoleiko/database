package com.holeiko.database.controller.impl;

import com.holeiko.database.controller.ClientController;
import com.holeiko.database.domain.Client;
import com.holeiko.database.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientControllerImpl implements ClientController {
    @Autowired
    private ClientService clientService;

    @Override
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @Override
    public Optional<Client> findById(Integer integer) {
        return clientService.findById(integer);
    }

    @Override
    public int create(Client entity) {
        return clientService.create(entity);
    }

    @Override
    public int update(Integer integer, Client entity) {
        return clientService.update(integer,entity);
    }

    @Override
    public int delete(Integer integer) {
        return clientService.delete(integer);
    }
}
