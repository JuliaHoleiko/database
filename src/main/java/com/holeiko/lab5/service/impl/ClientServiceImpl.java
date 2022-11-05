package com.holeiko.lab5.service.impl;

import com.holeiko.lab5.domain.Clients;
import com.holeiko.lab5.exceptions.ClientNotFoundException;
import com.holeiko.lab5.repository.ClientRepository;
import com.holeiko.lab5.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;


    @Override
    public List<Clients> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Clients findById(Integer integer) {
        return clientRepository.findById(integer) .orElseThrow(() -> new ClientNotFoundException(integer));
    }

    @Override
    public Clients create(Clients entity) {
        clientRepository.save(entity);
        return entity;
    }

    @Override
    public void update(Integer integer, Clients entity) {

        Clients client = clientRepository.findById(integer).orElseThrow(() -> new ClientNotFoundException(integer));
        client.setName(entity.getName());
        client.setSurname(entity.getSurname());
        client.setPhoneNumber(entity.getPhoneNumber());
        client.setEmail(entity.getEmail());
        clientRepository.save(client);


    }

    @Override
    public void delete(Integer integer) {
        Clients client = clientRepository.findById(integer)
                .orElseThrow(() -> new ClientNotFoundException(integer));
        clientRepository.delete(client);

    }
}
