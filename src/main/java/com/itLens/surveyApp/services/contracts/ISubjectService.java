package com.itLens.surveyApp.services.contracts;

import com.itLens.surveyApp.models.dtos.subject.CreateSubjectDTO;
import com.itLens.surveyApp.models.dtos.subject.SubjectDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.CreateSurveyEditionDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.SurveyEditionDTO;
import com.itLens.surveyApp.services.IGenericService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;

public interface ISubjectService {

    ApiResponse findAll(String id);
    ApiResponse findById(String id);
    ApiResponse save(CreateSubjectDTO entityDTO);
    ApiResponse update(String id, SubjectDTO entityDTO);
    ApiResponse delete(String id);

}
