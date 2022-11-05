package com.holeiko.lab5.dto.assembler;

import com.holeiko.lab5.controller.ClientsController;
import com.holeiko.lab5.domain.Areas;
import com.holeiko.lab5.domain.Clients;
import com.holeiko.lab5.dto.AreaDto;
import com.holeiko.lab5.dto.ClientDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class ClientsDtoAssembler implements RepresentationModelAssembler<Clients, ClientDto> {
    @Override
    public ClientDto toModel(Clients entity) {
        ClientDto clientDto = ClientDto.builder()
                .id(entity.getClientId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())

                .build();

        return clientDto;
    }

    @Override
    public CollectionModel<ClientDto> toCollectionModel(Iterable<? extends Clients> entities) {
        CollectionModel<ClientDto> clientDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        //Link selfLink = linkTo(methodOn(ClientsController.class).getAllCities()).withSelfRel();
        //clientDtos.add(selfLink);
        return clientDtos;



    }
}
