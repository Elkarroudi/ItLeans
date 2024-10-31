package com.itLens.surveyApp.models.mappers.contracts;

import com.itLens.surveyApp.models.dtos.owner.OwnerDTO;
import com.itLens.surveyApp.models.dtos.owner.OwnerResponseDTO;
import com.itLens.surveyApp.models.entities.Owner;
import com.itLens.surveyApp.models.mappers.IGenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper extends IGenericMapper<Owner, OwnerDTO, OwnerResponseDTO> {
}
