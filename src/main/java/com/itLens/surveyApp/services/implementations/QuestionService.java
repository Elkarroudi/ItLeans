package com.itLens.surveyApp.services.implementations;

import com.itLens.surveyApp.models.dtos.question.CreateQuestionDTO;
import com.itLens.surveyApp.models.dtos.question.QuestionDTO;
import com.itLens.surveyApp.models.dtos.question.QuestionResponseDTO;
import com.itLens.surveyApp.models.entities.Question;
import com.itLens.surveyApp.models.entities.Survey;
import com.itLens.surveyApp.models.enums.QuestionType;
import com.itLens.surveyApp.models.mappers.contracts.QuestionMapper;
import com.itLens.surveyApp.repositories.QuestionRepository;
import com.itLens.surveyApp.repositories.SubjectRepository;
import com.itLens.surveyApp.services.contracts.IQuestionService;
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
public class QuestionService implements IQuestionService {

    private QuestionRepository questionRepository;
    private SubjectRepository subjectRepository;
    private QuestionMapper questionMapper;


    @Override
    public ApiResponse findAll(String id) {
        List<QuestionResponseDTO> questionResponseDTO = questionRepository.getAllBySubjectId(id)
                .stream()
                .map(questionMapper::toResponseDtoFromEntityWithAllRelationShips)
                .toList();

        return new SuccessApi<>(200, questionResponseDTO);
    }

    @Override
    public ApiResponse findById(String id) {
        Map<String, String> errors = new HashMap<>();
        QuestionResponseDTO questionResponseDTO = questionMapper.toResponseDtoFromEntityWithAllRelationShips(
                questionRepository.findById(id).orElse(null)
        );

        if (questionResponseDTO == null) {
            errors.put("question", "Question Does Not Exists With This Id");
            return new ErrorApi(404, errors);
        }
        return new SuccessApi<>(200, questionResponseDTO);
    }

    @Override
    public ApiResponse save(CreateQuestionDTO createQuestionDTO) {

        Question question = questionMapper.toEntityFromCreateDto(createQuestionDTO);
        question.setSubject(
                subjectRepository.findById(createQuestionDTO.subjectId()).orElse(null)
        );

        question.setSubject(subjectRepository.findById(createQuestionDTO.subjectId()).orElse(null));

        Question newQuestion = questionRepository.save(question);
        QuestionResponseDTO questionResponseDTO = questionMapper.toResponseDtoFromEntityWithAllRelationShips(newQuestion);

        return new SuccessApi<>(200, questionResponseDTO);
    }

    @Override
    public ApiResponse update(String id, QuestionDTO questionDTO) {
        Question question = questionRepository.findById(id).orElse(null);
        questionMapper.updateEntityFromDto(questionDTO, question);

        QuestionResponseDTO questionResponseDTO = questionMapper.toResponseDtoFromEntityWithAllRelationShips(
                questionRepository.save(question)
        );

        return new SuccessApi<>(200, questionResponseDTO);
    }

    @Override
    public ApiResponse delete(String id) {
        Map<String, String> errors = new HashMap<>();
        Question question = questionRepository.findById(id).orElse(null);
        if (question == null) {
            errors.put("question", "Question Does Not Exists With This Id");
            return new ErrorApi(404, errors);
        }

        questionRepository.delete(question);
        return new SuccessApi<>(200, "Question deleted successfully");
    }
}
