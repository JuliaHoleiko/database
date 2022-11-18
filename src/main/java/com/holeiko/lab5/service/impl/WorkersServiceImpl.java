package com.holeiko.lab5.service.impl;

import com.holeiko.lab5.domain.Clients;
import com.holeiko.lab5.domain.Workers;
import com.holeiko.lab5.exceptions.ClientNotFoundException;
import com.holeiko.lab5.exceptions.WorkersNotFoundException;
import com.holeiko.lab5.repository.WorkersRepository;
import com.holeiko.lab5.service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkersServiceImpl implements WorkersService {
    @Autowired
    WorkersRepository workersRepository;

    @Override
    public List<Workers> findAll() {
        return workersRepository.findAll();
    }

    @Override
    public Workers findById(Integer integer) {
         return workersRepository.findById(integer) .orElseThrow(() -> new WorkersNotFoundException(integer));
    }

    @Override
    public Workers create(Workers entity) {
        workersRepository.save(entity);
        return entity;
    }

    @Override
    public void update(Integer integer, Workers entity) {

        Workers workers = workersRepository.findById(integer).orElseThrow(() -> new WorkersNotFoundException(integer));
        workers.setAreaId(entity.getAreaId());
        workers.setWorkers(entity.getWorkers());


        workersRepository.save(workers);

    }

    @Override
    public void delete(Integer integer) {
        Workers workers = workersRepository.findById(integer)
                .orElseThrow(() -> new WorkersNotFoundException(integer));
        workersRepository.delete(workers);


    }
}
