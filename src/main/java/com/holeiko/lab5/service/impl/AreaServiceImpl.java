package com.holeiko.lab5.service.impl;

import com.holeiko.lab5.domain.Areas;
import com.holeiko.lab5.domain.Clients;
import com.holeiko.lab5.dto.AreaDto;
import com.holeiko.lab5.exceptions.AreaNotFoundException;
import com.holeiko.lab5.exceptions.ClientNotFoundException;
import com.holeiko.lab5.repository.AreaRepository;
import com.holeiko.lab5.repository.ClientRepository;
import com.holeiko.lab5.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    AreaRepository areaRepository;
    @Autowired
    ClientRepository clientRepository;


    public List<Areas> findAll() {
        return areaRepository.findAll();
    }

    @Override
    public Areas findById(Integer integer) {
        return areaRepository.findById(integer).orElseThrow(() -> new AreaNotFoundException(integer));
    }

    @Override
    public Areas create(Areas entity) {
        return null;
    }

    @Transactional
    public Areas create(AreaDto entity) {
        Clients clients = clientRepository.findById(entity.getClientId()).orElseThrow(() -> new NullPointerException());
        Areas area = new Areas(entity.getId(),entity.getSquare(), entity.getLatitude(), entity.getLongitude(),clients);
        areaRepository.save(area);

        return area;
    }

    @Transactional
    public void update(Integer integer, Areas entity) {
        Areas area = areaRepository.findById(integer).orElseThrow(() -> new AreaNotFoundException(integer));
        area.setSquare(entity.getSquare());
        area.setLatitude(entity.getLatitude());
        area.setLongitude(entity.getLongitude());
        areaRepository.save(area);

    }

    @Transactional
    public Areas create(Areas entity, Integer clientsId) {
        Clients client = clientRepository.findById(clientsId)
                .orElseThrow(() -> new ClientNotFoundException(clientsId));
        entity.setClientsByOwnerClient(client);


        areaRepository.save(entity);

        return entity;
    }

    @Transactional
    public void update(Integer integer, Areas entity, Integer clientsId) {
        Areas area = areaRepository.findById(integer).orElseThrow(() -> new AreaNotFoundException(integer));
        area.setSquare(entity.getSquare());
        area.setLatitude(entity.getLatitude());
        area.setLongitude(entity.getLongitude());

        Clients client = clientRepository.findById(clientsId)
                .orElseThrow(() -> new ClientNotFoundException(clientsId));
        area.setClientsByOwnerClient(client);


        areaRepository.save(area);


    }

    @Transactional
    public void delete(Integer integer) {
        Areas area = areaRepository.findById(integer)
                .orElseThrow(() -> new AreaNotFoundException(integer));
        areaRepository.delete(area);

    }
}
