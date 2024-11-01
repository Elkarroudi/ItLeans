package com.itLens.surveyApp.models.mappers.contracts;

import com.itLens.surveyApp.models.dtos.answer.AnswerDTO;
import com.itLens.surveyApp.models.dtos.answer.AnswerResponseDTO;
import com.itLens.surveyApp.models.dtos.answer.CreateAnswerDTO;
import com.itLens.surveyApp.models.dtos.owner.CreateOwnerDTO;
import com.itLens.surveyApp.models.entities.Answer;
import com.itLens.surveyApp.models.mappers.IGenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface AnswerMapper extends IGenericMapper<Answer, AnswerDTO, CreateAnswerDTO, AnswerResponseDTO> {
}
