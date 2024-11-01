package com.itLens.surveyApp.models.mappers.contracts;

import com.itLens.surveyApp.models.dtos.survey.CreateSurveyDTO;
import com.itLens.surveyApp.models.dtos.survey.SurveyDTO;
import com.itLens.surveyApp.models.dtos.survey.SurveyResponseDTO;
import com.itLens.surveyApp.models.entities.Survey;
import com.itLens.surveyApp.models.mappers.IGenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SurveyMapper extends IGenericMapper<Survey, SurveyDTO, CreateSurveyDTO, SurveyResponseDTO> {
}
