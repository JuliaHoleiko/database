package com.holeiko.lab5.service.impl;

import com.holeiko.lab5.domain.LightSensorInfo;
import com.holeiko.lab5.domain.LightSensorWork;
import com.holeiko.lab5.dto.LightSensorWorkDto;
import com.holeiko.lab5.exceptions.LightSensorException;
import com.holeiko.lab5.exceptions.LightSensorWorkException;
import com.holeiko.lab5.repository.LightSensorInfoRepository;
import com.holeiko.lab5.repository.LightSensorWorkRepository;
import com.holeiko.lab5.service.LightSensorWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LightSensorWorkServiceImpl implements LightSensorWorkService {
    @Autowired
    LightSensorWorkRepository lightSensorWorkRepository;
    @Autowired
    LightSensorInfoRepository lightSensorInfoRepository;

    @Override
    public List<LightSensorWork> findAll() {
        return lightSensorWorkRepository.findAll();
    }

    @Override
    public LightSensorWork findById(Integer integer) {
        return lightSensorWorkRepository.findById(integer).orElseThrow(() -> new LightSensorWorkException());
    }

    @Override
    public LightSensorWork create(LightSensorWork entity) {
        return null;
    }

    public LightSensorWork create(LightSensorWorkDto entity) {
        LightSensorInfo sensor = lightSensorInfoRepository.findById(entity.getSensorId()).orElseThrow(() -> new NullPointerException());
        LightSensorWork lightSensorWork = new LightSensorWork(entity.getId(), entity.getLight(), entity.getTime(), sensor);
        lightSensorWorkRepository.save(lightSensorWork);
        return lightSensorWork;
    }

    @Override
    public void update(Integer integer, LightSensorWork entity) {

    }
    public void update(Integer integer, LightSensorWorkDto entity) {
        LightSensorInfo sensor = lightSensorInfoRepository.findById(entity.getSensorId()).orElseThrow(() -> new LightSensorException(entity.getSensorId()));
        LightSensorWork sensorWork = lightSensorWorkRepository.findById(integer).orElseThrow(() -> new LightSensorWorkException());
        sensorWork.setLight(entity.getLight());
        sensorWork.setTime(entity.getTime());
        sensorWork.setLightSensorInfoBySensorId(sensor);
        lightSensorWorkRepository.save(sensorWork);


    }

    @Override
    public void delete(Integer integer) {
        LightSensorWork lightSensorWork = lightSensorWorkRepository.findById(integer)
                .orElseThrow(()-> new LightSensorWorkException());
        lightSensorWorkRepository.delete(lightSensorWork);

    }
}
