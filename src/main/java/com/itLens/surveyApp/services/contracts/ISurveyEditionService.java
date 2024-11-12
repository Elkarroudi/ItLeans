package com.itLens.surveyApp.services.contracts;

import com.itLens.surveyApp.models.dtos.surveyEdition.CreateSurveyEditionDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.SurveyEditionDTO;
import com.itLens.surveyApp.services.IGenericService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;

public interface ISurveyEditionService {

    ApiResponse findAll(String id);
    ApiResponse findById(String id);
    ApiResponse save(CreateSurveyEditionDTO entityDTO);
    ApiResponse update(String id, SurveyEditionDTO entityDTO);
    ApiResponse delete(String id);

}
