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

import java.util.List;

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
        QuestionResponseDTO questionResponseDTO = questionMapper.toResponseDtoFromEntityWithAllRelationShips(
                questionRepository.findById(id).orElse(null)
        );

        if (questionResponseDTO == null) { return new ErrorApi(404, new String[]{"Question not found with Id: " + id}); }
        return new SuccessApi<>(200, questionResponseDTO);
    }

    @Override
    public ApiResponse save(CreateQuestionDTO createQuestionDTO) {
        QuestionType questionType;
        try {
            questionType = QuestionType.valueOf(createQuestionDTO.questionType().toString().toUpperCase());
        } catch (IllegalArgumentException e) {
            return new ErrorApi(400, new String[]{"Invalid question type"});
        }

        Question question = questionMapper.toEntityFromCreateDto(createQuestionDTO);
        question.setQuestionType(questionType);
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
        Question question = questionRepository.findById(id).orElse(null);
        if (question == null) { return new ErrorApi(404, new String[]{"Question not found"}); }

        questionRepository.delete(question);
        return new SuccessApi<>(200, "Question deleted successfully");
    }
}
