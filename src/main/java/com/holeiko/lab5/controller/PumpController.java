package com.holeiko.lab5.controller;

import com.holeiko.lab5.domain.LightSensorInfo;
import com.holeiko.lab5.domain.PumpsInfo;
import com.holeiko.lab5.dto.LightSensorInfoDto;
import com.holeiko.lab5.dto.PumpDto;
import com.holeiko.lab5.dto.assembler.AreaDtoAssembler;
import com.holeiko.lab5.dto.assembler.LightDtoAssembler;
import com.holeiko.lab5.dto.assembler.PumpDtoAssembler;
import com.holeiko.lab5.service.PumpService;
import com.holeiko.lab5.service.impl.AreaServiceImpl;
import com.holeiko.lab5.service.impl.LightSensorInfoServiceImpl;
import com.holeiko.lab5.service.impl.PumpServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pumps")
@Api(tags = "Pump")
public class PumpController {
    @Autowired
    AreaServiceImpl areaService;

   @Autowired
    PumpServiceImpl pumpService;


    @Autowired
    AreaDtoAssembler areaDtoAssembler;
    @Autowired
    PumpDtoAssembler pumpDtoAssembler;

    @GetMapping(value = "/{sensorId}")
    public ResponseEntity<PumpDto> getSensor(@PathVariable Integer sensorId) {
        PumpsInfo pumpsInfo = pumpService.findById(sensorId);
        PumpDto pumpDto = pumpDtoAssembler.toModel(pumpsInfo);
        return new ResponseEntity<>(pumpDto, HttpStatus.OK);
    }
    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<PumpDto>> getAllSensors() {
        List<PumpsInfo> pumpsInfo = pumpService.findAll();
        CollectionModel<PumpDto> pumpDtos = pumpDtoAssembler.toCollectionModel(pumpsInfo);
        return new ResponseEntity<>(pumpDtos, HttpStatus.OK);
    }


    @PostMapping(value = "")
    public ResponseEntity<PumpDto> addSensor(@RequestBody PumpDto pump) {
        PumpsInfo newPump = pumpService.create(pump);
        PumpDto pumpDto = pumpDtoAssembler.toModel(newPump);
        return new ResponseEntity<>(pumpDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{pumpId}")
    public ResponseEntity<?> updatePump(@RequestBody PumpDto pump, @PathVariable Integer pumpId) {
        pumpService.update(pumpId, pump);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{pumpId}")
    public ResponseEntity<?> deletePump(@PathVariable Integer pumpId) {
        pumpService.delete(pumpId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
