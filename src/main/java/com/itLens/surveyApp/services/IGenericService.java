package com.itLens.surveyApp.services;

import com.itLens.surveyApp.utils.responseEntities.ApiResponse;

public interface IGenericService<EntityDTO, CreateEntityDTO> {

    ApiResponse findAll();
    ApiResponse findById(String id);
    ApiResponse save(CreateEntityDTO entityDTO);
    ApiResponse update(String id, EntityDTO entityDTO);
    ApiResponse delete(String id);

}
