package com.itLens.surveyApp.services;

import java.util.List;

public interface IGenericService<Entity, EntityDTO, ResponseDTO, CreateEntityDTO> {

    List<ResponseDTO> findAll();
    ResponseDTO findById(String id);
    ResponseDTO save(CreateEntityDTO entityDTO);
    ResponseDTO update(String id, EntityDTO entityDTO);
    void delete(String id);

}
