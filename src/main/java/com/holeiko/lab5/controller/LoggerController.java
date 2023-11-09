package com.holeiko.lab5.controller;

import com.holeiko.lab5.domain.Areas;
import com.holeiko.lab5.domain.Clients;
import com.holeiko.lab5.domain.Logger;
import com.holeiko.lab5.dto.AreaDto;
import com.holeiko.lab5.dto.LoggerDto;
import com.holeiko.lab5.dto.assembler.LoggerDtoAssembler;
import com.holeiko.lab5.service.LoggerService;
import com.holeiko.lab5.service.impl.LoggerServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/logger")
@Api(tags = "Logger")
public class LoggerController  {
    @Autowired
    LoggerServiceImpl loggerService;

    @Autowired
    LoggerDtoAssembler loggerDtoAssembler;

    @GetMapping(value = "/{loggerId}")
    public ResponseEntity<LoggerDto> getLogger(@PathVariable Integer loggerId) {
        Logger logger = loggerService.findById(loggerId);
        LoggerDto loggerDto = loggerDtoAssembler.toModel(logger);
        return new ResponseEntity<>(loggerDto, HttpStatus.OK);
    }
    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<LoggerDto>> getAllLoggers() {
        List<Logger> loggers = loggerService.findAll();
        CollectionModel<LoggerDto> loggerDtos = loggerDtoAssembler.toCollectionModel(loggers);
        return new ResponseEntity<>(loggerDtos, HttpStatus.OK);
    }





}
