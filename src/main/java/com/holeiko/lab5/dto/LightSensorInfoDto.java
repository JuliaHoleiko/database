package com.holeiko.lab5.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "light_sensor", collectionRelation = "light_sensors")
public class LightSensorInfoDto extends RepresentationModel<LightSensorInfoDto> {
    private final Integer sensorId;
    private final Integer areasId;
    private final BigDecimal latitude;
    private final BigDecimal longitude;

}
