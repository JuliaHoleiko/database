package com.holeiko.lab5.dto.assembler;

import com.holeiko.lab5.controller.AreaController;
import com.holeiko.lab5.domain.Areas;
import com.holeiko.lab5.dto.AreaDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AreaDtoAssembler implements RepresentationModelAssembler<Areas, AreaDto> {

    @Override
    public AreaDto toModel(Areas entity) {
        AreaDto areaDto = AreaDto.builder()
                .id(entity.getId())
                .square(entity.getSquare()).
                latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .clientId(entity.getClientsByOwnerClient().getClientId())
                .build();

        return areaDto;
    }

    @Override
    public CollectionModel<AreaDto> toCollectionModel(Iterable<? extends Areas> entities) {

        CollectionModel<AreaDto> areaDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(AreaController.class).getClass()).withSelfRel();
        areaDtos.add(selfLink);
        return areaDtos;

    }
}
