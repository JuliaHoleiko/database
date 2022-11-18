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
@Relation(itemRelation = "logger", collectionRelation = "loggers")
public class LoggerDto extends RepresentationModel<LoggerDto> {
    private final Integer id;
    private final String clientName;
    private final Integer areaId;
    private final Timestamp timeStamp;
    private final String action;
}
