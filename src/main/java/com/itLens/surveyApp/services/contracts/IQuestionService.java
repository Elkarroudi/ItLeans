package com.itLens.surveyApp.services.contracts;

import com.itLens.surveyApp.models.dtos.question.CreateQuestionDTO;
import com.itLens.surveyApp.models.dtos.question.QuestionDTO;
import com.itLens.surveyApp.models.dtos.subject.CreateSubjectDTO;
import com.itLens.surveyApp.models.dtos.subject.SubjectDTO;
import com.itLens.surveyApp.services.IGenericService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;

public interface IQuestionService {

    ApiResponse findAll(String id);
    ApiResponse findById(String id);
    ApiResponse save(CreateQuestionDTO entityDTO);
    ApiResponse update(String id, QuestionDTO entityDTO);
    ApiResponse delete(String id);

}
