package com.holeiko.lab5.service.impl;

import com.holeiko.lab5.domain.Areas;
import com.holeiko.lab5.domain.PumpsInfo;
import com.holeiko.lab5.domain.WaterSystem;
import com.holeiko.lab5.dto.PumpDto;
import com.holeiko.lab5.dto.WaterSystemDto;
import com.holeiko.lab5.exceptions.AreaNotFoundException;
import com.holeiko.lab5.exceptions.PumpNotFoundExceptions;
import com.holeiko.lab5.exceptions.WaterSystemNotFoundException;
import com.holeiko.lab5.repository.PumpsInfoRepository;
import com.holeiko.lab5.repository.WaterSystemRepository;
import com.holeiko.lab5.service.WaterSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterSystemServiceImpl implements WaterSystemService {
    @Autowired
    PumpsInfoRepository pumpsInfoRepository;
    @Autowired
    WaterSystemRepository waterSystemRepository;

    @Override
    public List<WaterSystem> findAll() {
        return waterSystemRepository.findAll();
    }

    @Override
    public WaterSystem findById(Integer integer) {
        return waterSystemRepository.findById(integer).orElseThrow(()-> new WaterSystemNotFoundException(integer));
    }

    @Override
    public WaterSystem create(WaterSystem entity) {
        return null;
    }
    public WaterSystem create(WaterSystemDto entity) {
        PumpsInfo pumpsInfo = pumpsInfoRepository.findById(entity.getPumpId()).orElseThrow(() -> new NullPointerException());
        WaterSystem waterSystem = new WaterSystem(entity.getId(),entity.getCountOfNozzles(),  pumpsInfo);
        waterSystemRepository.save(waterSystem);

        return waterSystem;
    }

    @Override
    public void update(Integer integer, WaterSystem entity) {

    }
    public void update(Integer integer, WaterSystemDto entity) {
        PumpsInfo pumpsInfo = pumpsInfoRepository.findById(entity.getId()).orElseThrow(() -> new PumpNotFoundExceptions(entity.getId()));
        WaterSystem waterSystem = waterSystemRepository.findById(integer).orElseThrow(() -> new WaterSystemNotFoundException(integer));
        waterSystem.setCountOfNozzles(entity.getCountOfNozzles());
        waterSystem.setPumpsInfoByPump(pumpsInfo);
        waterSystemRepository.save(waterSystem);

    }


    @Override
    public void delete(Integer integer) {
        WaterSystem waterSystem = waterSystemRepository.findById(integer).orElseThrow(()-> new WaterSystemNotFoundException(integer));
        waterSystemRepository.delete(waterSystem);

    }
}
