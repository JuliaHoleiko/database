package com.holeiko.lab5.controller;

import com.holeiko.lab5.domain.Clients;
import com.holeiko.lab5.domain.LightSensorInfo;
import com.holeiko.lab5.dto.ClientDto;
import com.holeiko.lab5.dto.LightSensorInfoDto;
import com.holeiko.lab5.dto.assembler.AreaDtoAssembler;
import com.holeiko.lab5.dto.assembler.LightDtoAssembler;
import com.holeiko.lab5.service.impl.AreaServiceImpl;
import com.holeiko.lab5.service.impl.LightSensorInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sensor_info")
public class LightSensorInfoController {
    @Autowired
    AreaServiceImpl areaService;

    @Autowired
    LightSensorInfoServiceImpl lightSensorInfoServiceImpl;

    @Autowired
    AreaDtoAssembler areaDtoAssembler;
    @Autowired
    LightDtoAssembler lightDtoAssembler;

    @GetMapping(value = "/{sensorId}")
    public ResponseEntity<LightSensorInfoDto> getSensor(@PathVariable Integer sensorId) {
        LightSensorInfo lightSensorInfo = lightSensorInfoServiceImpl.findById(sensorId);
        LightSensorInfoDto lightSensorInfoDto = lightDtoAssembler.toModel(lightSensorInfo);
        return new ResponseEntity<>(lightSensorInfoDto, HttpStatus.OK);
    }
    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<LightSensorInfoDto>> getAllSensors() {
        List<LightSensorInfo> lightSensorInfos = lightSensorInfoServiceImpl.findAll();
        CollectionModel<LightSensorInfoDto> lightSensorInfoDtos = lightDtoAssembler.toCollectionModel(lightSensorInfos);
        return new ResponseEntity<>(lightSensorInfoDtos, HttpStatus.OK);
    }


    @PostMapping(value = "")
    public ResponseEntity<LightSensorInfoDto> addSensor(@RequestBody LightSensorInfoDto sensor) {
        LightSensorInfo newSensor = lightSensorInfoServiceImpl.create(sensor);
        LightSensorInfoDto lightSensorInfoDto = lightDtoAssembler.toModel(newSensor);
        return new ResponseEntity<>(lightSensorInfoDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{sensorId}")
    public ResponseEntity<?> updateSensor(@RequestBody LightSensorInfo sensor, @PathVariable Integer sensorId) {
        lightSensorInfoServiceImpl.update(sensorId, sensor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{sensorId}")
    public ResponseEntity<?> deleteSensor(@PathVariable Integer sensorId) {
        lightSensorInfoServiceImpl.delete(sensorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
