package com.itLens.surveyApp.models.mappers;

public interface IGenericMapper<Entity, EntityDTO, EntityResponseDTO> {

    Entity toEntity(EntityDTO entityDTO);
    EntityDTO toDto(Entity entity);
    EntityResponseDTO toResponseDto(Entity entity);
    Entity fromResponseDto(EntityResponseDTO entityResponseDTO);

}
