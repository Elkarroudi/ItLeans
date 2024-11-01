package com.itLens.surveyApp.models.mappers.contracts;

import com.itLens.surveyApp.models.dtos.surveyEdition.CreateSurveyEditionDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.SurveyEditionDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.SurveyEditionResponseDTO;
import com.itLens.surveyApp.models.entities.SurveyEdition;
import com.itLens.surveyApp.models.mappers.IGenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SurveyEditionMapper extends IGenericMapper<SurveyEdition, SurveyEditionDTO, CreateSurveyEditionDTO, SurveyEditionResponseDTO> {
}
