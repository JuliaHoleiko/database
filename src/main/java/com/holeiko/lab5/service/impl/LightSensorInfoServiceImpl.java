package com.holeiko.lab5.service.impl;

import com.holeiko.lab5.domain.Areas;
import com.holeiko.lab5.domain.Clients;
import com.holeiko.lab5.domain.LightSensorInfo;
import com.holeiko.lab5.dto.LightSensorInfoDto;
import com.holeiko.lab5.exceptions.AreaNotFoundException;
import com.holeiko.lab5.exceptions.LightSensorException;
import com.holeiko.lab5.repository.AreaRepository;
import com.holeiko.lab5.repository.LightSensorInfoRepository;
import com.holeiko.lab5.service.LightSensorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LightSensorInfoServiceImpl implements LightSensorInfoService {
    @Autowired
    LightSensorInfoRepository lightSensorInfoRepository;

    @Autowired
    AreaRepository areaRepository;

    @Override
    public List<LightSensorInfo> findAll() {
        return lightSensorInfoRepository.findAll();
    }

    @Override
    public LightSensorInfo findById(Integer integer) {
        return lightSensorInfoRepository.findById(integer).orElseThrow(() -> new LightSensorException(integer));
    }

    @Override
    public LightSensorInfo create(LightSensorInfo entity) {
        return null;

    }
    public LightSensorInfo create(LightSensorInfoDto entity) {
        Areas area = areaRepository.findById(entity.getAreasId()).orElseThrow(() -> new NullPointerException());
        LightSensorInfo lightSensorInfo = new LightSensorInfo(entity.getSensorId(),entity.getLatitude(),  entity.getLongitude(),area);
        lightSensorInfoRepository.save(lightSensorInfo);

        return lightSensorInfo;
    }

    @Override
    public void update(Integer integer, LightSensorInfo entity) {
        LightSensorInfo lightSensorInfo = lightSensorInfoRepository.findById(integer).orElseThrow(() -> new LightSensorException(integer));
        lightSensorInfo.setLongitude(entity.getLongitude());
        lightSensorInfo.setLatitude(entity.getLatitude());
        lightSensorInfoRepository.save(lightSensorInfo);

    }

    @Override
    public void delete(Integer integer) {
        LightSensorInfo lightSensorInfo = lightSensorInfoRepository.findById(integer)
                .orElseThrow(() -> new LightSensorException(integer));
        lightSensorInfoRepository.delete(lightSensorInfo);

    }
}
