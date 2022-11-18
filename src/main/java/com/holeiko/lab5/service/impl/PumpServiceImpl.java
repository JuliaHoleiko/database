package com.holeiko.lab5.service.impl;

import com.holeiko.lab5.domain.Areas;
import com.holeiko.lab5.domain.LightSensorInfo;
import com.holeiko.lab5.domain.LightSensorWork;
import com.holeiko.lab5.domain.PumpsInfo;
import com.holeiko.lab5.dto.LightSensorWorkDto;
import com.holeiko.lab5.dto.PumpDto;
import com.holeiko.lab5.exceptions.AreaNotFoundException;
import com.holeiko.lab5.exceptions.LightSensorException;
import com.holeiko.lab5.exceptions.LightSensorWorkException;
import com.holeiko.lab5.exceptions.PumpNotFoundExceptions;
import com.holeiko.lab5.repository.AreaRepository;
import com.holeiko.lab5.repository.PumpsInfoRepository;
import com.holeiko.lab5.service.PumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PumpServiceImpl implements PumpService {
    @Autowired
    AreaRepository areaRepository;
    @Autowired
    PumpsInfoRepository pumpsInfoRepository;

    @Override
    public List<PumpsInfo> findAll() {
        return pumpsInfoRepository.findAll();
    }

    @Override
    public PumpsInfo findById(Integer integer) {
        return pumpsInfoRepository.findById(integer).orElseThrow(()-> new PumpNotFoundExceptions(integer));
    }

    @Override
    public PumpsInfo create(PumpsInfo entity) {
        return null;
    }

    public PumpsInfo create(PumpDto entity) {
        Areas area = areaRepository.findById(entity.getAreasId()).orElseThrow(() -> new NullPointerException());
        PumpsInfo pumpsInfo = new PumpsInfo(entity.getId(),entity.getCountOfMotors(),  entity.getWaterConsume(),area);
        pumpsInfoRepository.save(pumpsInfo);

        return pumpsInfo;
    }

    @Override
    public void update(Integer integer, PumpsInfo entity) {

    }
    public void update(Integer integer, PumpDto entity) {
        Areas area = areaRepository.findById(entity.getAreasId()).orElseThrow(() -> new AreaNotFoundException(entity.getAreasId()));
        PumpsInfo pump = pumpsInfoRepository.findById(integer).orElseThrow(() -> new PumpNotFoundExceptions(integer));
        pump.setCountOfMotors(entity.getCountOfMotors());
        pump.setWaterConsume(entity.getWaterConsume());
        pump.setArea(area);
        pumpsInfoRepository.save(pump);


    }

    @Override
    public void delete(Integer integer) {
        PumpsInfo pumpsInfo = pumpsInfoRepository.findById(integer)
                .orElseThrow(()-> new PumpNotFoundExceptions(integer));
        pumpsInfoRepository.delete(pumpsInfo);



    }
}
