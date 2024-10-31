package com.itLens.surveyApp.models.mappers.contracts;

import com.itLens.surveyApp.models.dtos.question.QuestionDTO;
import com.itLens.surveyApp.models.dtos.question.QuestionResponseDTO;
import com.itLens.surveyApp.models.entities.Question;
import com.itLens.surveyApp.models.mappers.IGenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper extends IGenericMapper<Question, QuestionDTO, QuestionResponseDTO> {
}
