package com.itLens.surveyApp.services.implementations;

import com.itLens.surveyApp.models.dtos.answer.AnswerDTO;
import com.itLens.surveyApp.models.dtos.answer.AnswerResponseDTO;
import com.itLens.surveyApp.models.dtos.answer.CreateAnswerDTO;
import com.itLens.surveyApp.models.dtos.survey.SurveyResponseDTO;
import com.itLens.surveyApp.models.entities.Answer;
import com.itLens.surveyApp.models.entities.Survey;
import com.itLens.surveyApp.models.mappers.contracts.AnswerMapper;
import com.itLens.surveyApp.repositories.AnswerRepository;
import com.itLens.surveyApp.repositories.QuestionRepository;
import com.itLens.surveyApp.services.contracts.IAnswerService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;
import com.itLens.surveyApp.utils.responseEntities.ErrorApi;
import com.itLens.surveyApp.utils.responseEntities.SuccessApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class AnswerService implements IAnswerService {

    private AnswerRepository answerRepository;
    private QuestionRepository questionRepository;
    private AnswerMapper answerMapper;


    @Override
    public ApiResponse findAll(String id) {
        List<AnswerResponseDTO> answers =  answerRepository.findAll()
                .stream()
                .map(answerMapper::toResponseDtoFromEntityWithAllRelationShips)
                .toList();

        return new SuccessApi<>(200, answers);
    }

    @Override
    public ApiResponse findById(String id) {
        Map<String, String> errors = new HashMap<>();
        AnswerResponseDTO answer = answerMapper.toResponseDtoFromEntityWithAllRelationShips(
                answerRepository.findById(id).orElse(null)
        );

        if (answer == null) {
            errors.put("error", "Answer Does NOt Exists With this id");
            return new ErrorApi(404, errors);
        }
        return new SuccessApi<>(200, answer);
    }

    @Override
    public ApiResponse save(CreateAnswerDTO createAnswerDTO) {
        Answer answer = answerMapper.toEntityFromCreateDto(createAnswerDTO);
        answer.setQuestion(
                questionRepository.findById(
                        createAnswerDTO.questionId()
                ).orElse(null)
        );

        Answer savedAnswer = answerRepository.save(answer);
        AnswerResponseDTO newAnswer = answerMapper.toResponseDtoFromEntityWithAllRelationShips(savedAnswer);

        return new SuccessApi<AnswerResponseDTO>(201, newAnswer);
    }

    @Override
    public ApiResponse update(String id, AnswerDTO answerDTO) {
        Answer answer = answerRepository.findById(id).orElse(null);
        answerMapper.updateEntityFromDto(answerDTO, answer);

        AnswerResponseDTO updatedAnswer = answerMapper.toResponseDtoFromEntityWithAllRelationShips(
                answerRepository.save(answer)
        );

        return new SuccessApi<AnswerResponseDTO>(200, updatedAnswer);
    }

    @Override
    public ApiResponse delete(String id) {
        Map<String, String> errors = new HashMap<>();
        Answer answer = answerRepository.findById(id).orElse(null);
        if (answer == null) {
            errors.put("error", "Answer Does NOt Exists With this id");
            return new ErrorApi(404, errors);
        }

        answerRepository.delete(answer);
        return new SuccessApi<>(200, "Survey deleted successfully");
    }
}
