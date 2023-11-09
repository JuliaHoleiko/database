package com.holeiko.lab5.dto.assembler;

import com.holeiko.lab5.domain.Workers;
import com.holeiko.lab5.dto.ClientDto;
import com.holeiko.lab5.dto.WorkersDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class WorkersDtoAssembler implements RepresentationModelAssembler<Workers, WorkersDto> {

    @Override
    public WorkersDto toModel(Workers entity) {
        WorkersDto workersDto = WorkersDto.builder()
                .id(entity.getId())
                .areaId(entity.getAreaId())
                .workers(entity.getWorkers())

                .build();

        return workersDto;
    }

    @Override
    public CollectionModel<WorkersDto> toCollectionModel(Iterable<? extends Workers> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
