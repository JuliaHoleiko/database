package com.holeiko.lab5.dto.assembler;

import com.holeiko.lab5.domain.LightSensorInfo;
import com.holeiko.lab5.dto.ClientDto;
import com.holeiko.lab5.dto.LightSensorInfoDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class LightDtoAssembler implements RepresentationModelAssembler<LightSensorInfo, LightSensorInfoDto> {
    @Override
    public LightSensorInfoDto toModel(LightSensorInfo entity) {
        LightSensorInfoDto lightSensorInfoDto = LightSensorInfoDto.builder()
                .sensorId(entity.getSensorId())
                .areasId(entity.getLightSensorInfoById().getId())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .build();

        return lightSensorInfoDto;
    }

    @Override
    public CollectionModel<LightSensorInfoDto> toCollectionModel(Iterable<? extends LightSensorInfo> entities) {
        CollectionModel<LightSensorInfoDto> lightSensorInfoDtos = RepresentationModelAssembler.super.toCollectionModel(entities);

        return lightSensorInfoDtos;}
}
