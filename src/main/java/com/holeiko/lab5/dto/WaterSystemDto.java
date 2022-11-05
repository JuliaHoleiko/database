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
@Relation(itemRelation = "watersys", collectionRelation = "water_systems")

public class WaterSystemDto extends RepresentationModel<WaterSystemDto> {
    private final Integer id;
    private final Integer countOfNozzles;
    private final Integer pumpId;

}
