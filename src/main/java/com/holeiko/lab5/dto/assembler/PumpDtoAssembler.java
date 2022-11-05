package com.holeiko.lab5.dto.assembler;

import com.holeiko.lab5.domain.PumpsInfo;
import com.holeiko.lab5.dto.PumpDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class PumpDtoAssembler implements RepresentationModelAssembler<PumpsInfo, PumpDto> {
    @Override
    public PumpDto toModel(PumpsInfo entity) {
        PumpDto pumpDto = PumpDto.builder()
                .id(entity.getId())
                .countOfMotors(entity.getCountOfMotors())
                .waterConsume(entity.getWaterConsume())
                .areasId(entity.getArea().getId())
                .build();
        return pumpDto;
    }

    @Override
    public CollectionModel<PumpDto> toCollectionModel(Iterable<? extends PumpsInfo> entities) {
        CollectionModel<PumpDto> pumpDtos =  RepresentationModelAssembler.super.toCollectionModel(entities);
        return pumpDtos;
    }
}
