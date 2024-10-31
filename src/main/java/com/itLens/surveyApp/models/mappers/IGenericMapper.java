package com.itLens.surveyApp.models.mappers;

public interface IGenericMapper<Entity, EntityDTO, CreateEntityDTO, EntityResponseDTO> {

    Entity toEntity(EntityDTO entityDTO);
    Entity toEntityFromCreateDto(CreateEntityDTO createEntityDTO);
    Entity toEntityFromResponseDto(EntityResponseDTO entityResponseDTO);

    EntityDTO toDtoFromEntity(Entity entity);
    EntityResponseDTO toResponseDtoFromEntity(Entity entity);

}
