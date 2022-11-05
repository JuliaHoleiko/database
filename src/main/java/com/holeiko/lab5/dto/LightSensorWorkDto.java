package com.holeiko.lab5.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Timestamp;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "light_sensor_work", collectionRelation = "light_sensors_work")
public class LightSensorWorkDto extends RepresentationModel<LightSensorWorkDto> {
    private final Integer id;
    private final Integer light;
    private final Timestamp time;
    private final Integer sensorId;
}
