package com.holeiko.lab5.controller;

import com.holeiko.lab5.domain.PumpsInfo;
import com.holeiko.lab5.domain.WaterSystem;
import com.holeiko.lab5.dto.PumpDto;
import com.holeiko.lab5.dto.WaterSystemDto;
import com.holeiko.lab5.dto.assembler.WaterSystemDtoAssembler;
import com.holeiko.lab5.service.impl.WaterSystemServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/water")
@Api(tags = "water system")
public class WaterSystemController {
    @Autowired
    WaterSystemServiceImpl waterSystemService;
    @Autowired
    WaterSystemDtoAssembler waterSystemDtoAssembler;

    @GetMapping(value = "/{systemId}")
    public ResponseEntity<WaterSystemDto> getSensor(@PathVariable Integer systemId) {
        WaterSystem waterSystem = waterSystemService.findById(systemId);
        WaterSystemDto waterSystemDto = waterSystemDtoAssembler.toModel(waterSystem);
        return new ResponseEntity<>(waterSystemDto, HttpStatus.OK);
    }
    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<WaterSystemDto>> getAllSensors() {
        List<WaterSystem> waterSystems = waterSystemService.findAll();
        CollectionModel<WaterSystemDto> waterSystemDtos = waterSystemDtoAssembler.toCollectionModel(waterSystems);
        return new ResponseEntity<>(waterSystemDtos, HttpStatus.OK);
    }


    @PostMapping(value = "")
    public ResponseEntity<WaterSystemDto> addSensor(@RequestBody WaterSystemDto waterSystem) {
        WaterSystem newWaterSystem = waterSystemService.create(waterSystem);
        WaterSystemDto waterSystemDto = waterSystemDtoAssembler.toModel(newWaterSystem);
        return new ResponseEntity<>(waterSystemDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{systemId}")
    public ResponseEntity<?> updatePump(@RequestBody WaterSystemDto waterSystemDto, @PathVariable Integer systemId) {
        waterSystemService.update(systemId, waterSystemDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{systemId}")
    public ResponseEntity<?> deletePump(@PathVariable Integer systemId) {
        waterSystemService.delete(systemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
