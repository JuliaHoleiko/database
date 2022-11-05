package com.holeiko.lab5.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "light_sensor", collectionRelation = "light_sensors")
public class PumpDto extends RepresentationModel<PumpDto> {
    private final Integer id;
    private final Integer countOfMotors;
    private final Integer waterConsume;
    private final Integer areasId;

}
