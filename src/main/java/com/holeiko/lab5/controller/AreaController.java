package com.holeiko.lab5.controller;

import com.holeiko.lab5.domain.Areas;
import com.holeiko.lab5.domain.Clients;
import com.holeiko.lab5.dto.AreaDto;
import com.holeiko.lab5.dto.ClientDto;
import com.holeiko.lab5.dto.assembler.AreaDtoAssembler;
import com.holeiko.lab5.dto.assembler.ClientsDtoAssembler;
import com.holeiko.lab5.service.AreaService;
import com.holeiko.lab5.service.ClientService;
import com.holeiko.lab5.service.impl.AreaServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/area")
@Api(tags = "Area")
public class AreaController {
    @Autowired
    AreaServiceImpl areaService;
    @Autowired
    ClientService clientService;
    @Autowired
    AreaDtoAssembler areaDtoAssembler;
    @Autowired
    ClientsDtoAssembler clientsDtoAssembler;


    @GetMapping(value = "/{areasId}")
    public ResponseEntity<AreaDto> getCity(@PathVariable Integer areasId) {
        Areas areas = areaService.findById(areasId);
        AreaDto areaDto = areaDtoAssembler.toModel(areas);
        return new ResponseEntity<>(areaDto, HttpStatus.OK);
    }
    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<AreaDto>> getAllClients() {
        List<Areas> areas = areaService.findAll();
        CollectionModel<AreaDto> areaDtos = areaDtoAssembler.toCollectionModel(areas);
        return new ResponseEntity<>(areaDtos, HttpStatus.OK);
    }


    @PostMapping(value = "")
    public ResponseEntity<AreaDto> addCity(@RequestBody AreaDto areas) {
        Areas newArea = areaService.create(areas);
        AreaDto areaDto = areaDtoAssembler.toModel(newArea);
        return new ResponseEntity<>(areaDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{clientId}")
    public ResponseEntity<?> updateCity(@RequestBody Areas area, @PathVariable Integer areasId) {
        areaService.update(areasId, area);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{clientId}")
    public ResponseEntity<?> deleteCity(@PathVariable Integer clientId) {
        areaService.delete(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
