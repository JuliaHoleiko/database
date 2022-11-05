package com.holeiko.lab5.dto.assembler;

import com.holeiko.lab5.domain.LightSensorWork;
import com.holeiko.lab5.dto.LightSensorInfoDto;
import com.holeiko.lab5.dto.LightSensorWorkDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class LightSensorWorkDtoAssembler implements RepresentationModelAssembler<LightSensorWork, LightSensorWorkDto> {
    @Override
    public LightSensorWorkDto toModel(LightSensorWork entity) {
        LightSensorWorkDto lightSensorWorkDto = LightSensorWorkDto.builder()
                .id(entity.getId())
                .light(entity.getLight())
                .time(entity.getTime())
                .sensorId(entity.getLightSensorInfoBySensorId().getSensorId())

                .build();
        return lightSensorWorkDto;
    }

    @Override
    public CollectionModel<LightSensorWorkDto> toCollectionModel(Iterable<? extends LightSensorWork> entities) {
        CollectionModel<LightSensorWorkDto> lightSensorWorkDtos = RepresentationModelAssembler.super.toCollectionModel(entities);

        return lightSensorWorkDtos;}
}
