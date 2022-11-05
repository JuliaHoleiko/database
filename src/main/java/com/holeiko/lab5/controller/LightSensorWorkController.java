package com.holeiko.lab5.controller;

import com.holeiko.lab5.domain.LightSensorInfo;
import com.holeiko.lab5.domain.LightSensorWork;
import com.holeiko.lab5.dto.LightSensorInfoDto;
import com.holeiko.lab5.dto.LightSensorWorkDto;
import com.holeiko.lab5.dto.assembler.LightDtoAssembler;
import com.holeiko.lab5.dto.assembler.LightSensorWorkDtoAssembler;
import com.holeiko.lab5.service.LightSensorWorkService;
import com.holeiko.lab5.service.impl.LightSensorInfoServiceImpl;
import com.holeiko.lab5.service.impl.LightSensorWorkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sensor_work")
public class LightSensorWorkController {
    @Autowired
    LightSensorInfoServiceImpl lightSensorInfoService;
    @Autowired
    LightSensorWorkServiceImpl lightSensorWorkService;

    @Autowired
    LightDtoAssembler lightDtoAssembler;
    @Autowired
    LightSensorWorkDtoAssembler lightSensorWorkDtoAssembler;
    @GetMapping(value = "/{workId}")
    public ResponseEntity<LightSensorWorkDto> getSensor(@PathVariable Integer workId) {
        LightSensorWork lightSensorWork = lightSensorWorkService.findById(workId);
        LightSensorWorkDto lightSensorWorkDto = lightSensorWorkDtoAssembler.toModel(lightSensorWork);
        return new ResponseEntity<>(lightSensorWorkDto, HttpStatus.OK);
    }
    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<LightSensorWorkDto>> getAllSensors() {
        List<LightSensorWork> lightSensorWorks = lightSensorWorkService.findAll();
        CollectionModel<LightSensorWorkDto> lightSensorWorkDtos = lightSensorWorkDtoAssembler.toCollectionModel(lightSensorWorks);
        return new ResponseEntity<>(lightSensorWorkDtos, HttpStatus.OK);
    }


    @PostMapping(value = "")
    public ResponseEntity<LightSensorWorkDto> addSensor(@RequestBody LightSensorWorkDto sensor) {
        LightSensorWork newWork = lightSensorWorkService.create(sensor);
        LightSensorWorkDto lightSensorWorkDto = lightSensorWorkDtoAssembler.toModel(newWork);
        return new ResponseEntity<>(lightSensorWorkDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{workId}")
    public ResponseEntity<?> updateSensor(@RequestBody LightSensorWorkDto sensor, @PathVariable Integer workId) {
        lightSensorWorkService.update(workId, sensor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{workId}")
    public ResponseEntity<?> deleteSensor(@PathVariable Integer workId) {
        lightSensorWorkService.delete(workId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
