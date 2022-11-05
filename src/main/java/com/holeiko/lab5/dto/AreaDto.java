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
@Relation(itemRelation = "area", collectionRelation = "areas")
public class AreaDto extends RepresentationModel<AreaDto> {
    private final Integer id;
    private final Integer square;
    private final BigDecimal latitude;
    private final BigDecimal longitude;
    private final Integer clientId;

}
