package com.holeiko.lab5.controller;

import com.holeiko.lab5.domain.Clients;
import com.holeiko.lab5.dto.ClientDto;
import com.holeiko.lab5.dto.assembler.ClientsDtoAssembler;
import com.holeiko.lab5.service.ClientService;
import com.holeiko.lab5.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/clients")
public class ClientsController {
    @Autowired
    ClientServiceImpl clientService;
    @Autowired
    ClientsDtoAssembler clientsDtoAssembler;

    @GetMapping(value = "/{clientId}")
    public ResponseEntity<ClientDto> getClient(@PathVariable Integer clientId) {
        Clients clients = clientService.findById(clientId);
        ClientDto clientDto = clientsDtoAssembler.toModel(clients);
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }
    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ClientDto>> getAllClients() {
        List<Clients> cities = clientService.findAll();
        CollectionModel<ClientDto> cityDtos = clientsDtoAssembler.toCollectionModel(cities);
        return new ResponseEntity<>(cityDtos, HttpStatus.OK);
    }


    @PostMapping(value = "")
    public ResponseEntity<ClientDto> addClient(@RequestBody Clients clients) {
        Clients newClient = clientService.create(clients);
        ClientDto clientDto = clientsDtoAssembler.toModel(newClient);
        return new ResponseEntity<>(clientDto, HttpStatus.CREATED);
    }
    @PostMapping(value = "/add")
    public void addClientProcedure(@RequestBody Clients clients) {
        clientService.AddClient(clients.getName(), clients.getSurname(), clients.getEmail(),clients.getPhoneNumber());
        System.out.println("add client");

    }
    @PostMapping(value = "/max_water")
    public Integer maxWaterConsume() {
        Integer result= clientService. getMaxWaterConsume();
        System.out.println(result);
        return result;
    }
    @PostMapping(value = "/create_tables")
    public void createTables() {
        clientService.createTables();
        System.out.println("create tables");
    }



        @PutMapping(value = "/{clientId}")
    public ResponseEntity<?> updateClient(@RequestBody Clients client, @PathVariable Integer clientId) {
        clientService.update(clientId, client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Integer clientId) {
        clientService.delete(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping(value = "/ten")
    public void addTenRecords(){
        clientService.AddTenFakeClients();
    }


}
