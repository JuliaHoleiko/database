package com.holeiko.lab5.controller;

import com.holeiko.lab5.domain.Clients;
import com.holeiko.lab5.domain.Workers;
import com.holeiko.lab5.dto.ClientDto;
import com.holeiko.lab5.dto.WorkersDto;
import com.holeiko.lab5.dto.assembler.WorkersDtoAssembler;
import com.holeiko.lab5.service.WorkersService;
import com.holeiko.lab5.service.impl.WorkersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/workers")
public class WorkersController {
    @Autowired
    WorkersDtoAssembler workersDtoAssembler;
    @Autowired
    WorkersServiceImpl workersService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkersDto> getClient(@PathVariable Integer id) {
    Workers workers = workersService.findById(id);

    WorkersDto workersDto = workersDtoAssembler.toModel(workers);
    return new ResponseEntity<>(workersDto, HttpStatus.OK);
}
    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<WorkersDto>> getAllClients() {
        List<Workers> workers = workersService.findAll();
        CollectionModel<WorkersDto> workersDtos = workersDtoAssembler.toCollectionModel(workers);
        return new ResponseEntity<>(workersDtos, HttpStatus.OK);
    }


    @PostMapping(value = "")
    public ResponseEntity<WorkersDto> addClient(@RequestBody Workers workers) {
        Workers newWorker = workersService.create(workers);
        WorkersDto workersDto = workersDtoAssembler.toModel(newWorker);
        return new ResponseEntity<>(workersDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{workersID}")
    public ResponseEntity<?> updateClient(@RequestBody Workers workers, @PathVariable Integer workersID) {
        workersService.update(workersID, workers);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{workersID}")
    public ResponseEntity<?> deleteClient(@PathVariable Integer workersID) {
        workersService.delete(workersID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}