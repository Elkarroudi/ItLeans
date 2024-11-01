package com.itLens.surveyApp.models.mappers;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

public interface IGenericMapper<Entity, EntityDTO, CreateEntityDTO, EntityResponseDTO> {

    Entity toEntity(EntityDTO entityDTO);
    Entity toEntityFromCreateDto(CreateEntityDTO createEntityDTO);
    Entity toEntityFromResponseDto(EntityResponseDTO entityResponseDTO);

    EntityDTO toDtoFromEntity(Entity entity);
    EntityResponseDTO toResponseDtoFromEntity(Entity entity);

    @Mapping(source = "entityDTO.id", target = "id")
    Entity updateEntityFromDto(EntityDTO entityDTO, @MappingTarget Entity entity);
}
