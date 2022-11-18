package com.holeiko.lab5.dto.assembler;

import com.holeiko.lab5.domain.Areas;
import com.holeiko.lab5.domain.Logger;
import com.holeiko.lab5.dto.AreaDto;
import com.holeiko.lab5.dto.LoggerDto;
import com.holeiko.lab5.dto.PumpDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class LoggerDtoAssembler implements RepresentationModelAssembler<Logger, LoggerDto> {

    @Override
    public LoggerDto toModel(Logger entity) {
        LoggerDto loggerDto = LoggerDto.builder()
                .id(entity.getId())
                .areaId(entity.getAreaId())
                .clientName(entity.getClientName())
                .timeStamp(entity.getTimeStamp())
                .action(entity.getAction())
                .build();
        return loggerDto;
    }

    @Override
    public CollectionModel<LoggerDto> toCollectionModel(Iterable<? extends Logger> entities) {
        CollectionModel<LoggerDto> loggerDtos =  RepresentationModelAssembler.super.toCollectionModel(entities);
        return loggerDtos;
    }
}
