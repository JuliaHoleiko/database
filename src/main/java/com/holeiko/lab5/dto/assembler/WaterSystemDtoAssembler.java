package com.holeiko.lab5.dto.assembler;

import com.holeiko.lab5.domain.WaterSystem;
import com.holeiko.lab5.dto.WaterSystemDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class WaterSystemDtoAssembler implements RepresentationModelAssembler<WaterSystem, WaterSystemDto>{

    @Override
    public WaterSystemDto toModel(WaterSystem entity) {
        WaterSystemDto waterSystemDto = WaterSystemDto.builder()
                .id(entity.getId())
                .countOfNozzles((entity.getCountOfNozzles()))
                .pumpId(entity.getPumpsInfoByPump().getId())
                .build();
        return waterSystemDto;

    }

    @Override
    public CollectionModel<WaterSystemDto> toCollectionModel(Iterable<? extends WaterSystem> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
