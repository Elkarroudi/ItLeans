package com.itLens.surveyApp.services.contracts;

import com.itLens.surveyApp.models.dtos.survey.CreateSurveyDTO;
import com.itLens.surveyApp.models.dtos.survey.SurveyDTO;
import com.itLens.surveyApp.services.IGenericService;

public interface ISurveyService extends IGenericService<SurveyDTO, CreateSurveyDTO> {
}
