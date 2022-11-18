package com.holeiko.lab5.service.impl;

import com.holeiko.lab5.domain.Logger;
import com.holeiko.lab5.exceptions.AreaNotFoundException;
import com.holeiko.lab5.exceptions.LoggerNotFoundException;
import com.holeiko.lab5.repository.LoggerRepository;
import com.holeiko.lab5.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class LoggerServiceImpl implements LoggerService {
    @Autowired
    LoggerRepository loggerRepository;

    @Override
    public List<Logger> findAll() {
        return loggerRepository.findAll();
    }

    @Override
    public Logger findById(Integer integer) {
        return loggerRepository.findById(integer).orElseThrow(() -> new LoggerNotFoundException(integer));
    }

    @Override
    public Logger create(Logger entity) {

            loggerRepository.save(entity);
            return entity;


    }

    @Override
    @Transactional
    public void update(Integer integer, Logger entity) {
        Logger logger = loggerRepository.findById(integer)
                .orElseThrow(() -> new LoggerNotFoundException(integer));
        //update
        logger.setAreaId(entity.getAreaId());
        logger.setClientName(entity.getClientName());
        logger.setTimeStamp(entity.getTimeStamp());
        logger.setAction(entity.getAction());
        loggerRepository.save(logger);

    }


    @Override
    @Transactional
    public void delete(Integer integer) {
        Logger logger = loggerRepository.findById(integer)
                .orElseThrow(() -> new LoggerNotFoundException(integer));
        loggerRepository.delete(logger);

    }
}
