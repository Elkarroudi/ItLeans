package com.itLens.surveyApp.services.contracts;

import com.itLens.surveyApp.models.dtos.answer.AnswerDTO;
import com.itLens.surveyApp.models.dtos.answer.CreateAnswerDTO;
import com.itLens.surveyApp.models.dtos.question.CreateQuestionDTO;
import com.itLens.surveyApp.models.dtos.question.QuestionDTO;
import com.itLens.surveyApp.services.IGenericService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;

public interface IAnswerService {

    ApiResponse findAll(String id);
    ApiResponse findById(String id);
    ApiResponse save(CreateAnswerDTO entityDTO);
    ApiResponse update(String id, AnswerDTO entityDTO);
    ApiResponse delete(String id);

}
