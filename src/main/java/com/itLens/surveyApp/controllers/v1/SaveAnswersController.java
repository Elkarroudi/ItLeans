package com.itLens.surveyApp.controllers.v1;

import com.itLens.surveyApp.models.dtos.AnswerPerQuestion;
import com.itLens.surveyApp.models.entities.SurveyEdition;
import com.itLens.surveyApp.repositories.AnswerRepository;
import com.itLens.surveyApp.repositories.QuestionRepository;
import com.itLens.surveyApp.repositories.SurveyEditionRepository;
import com.itLens.surveyApp.repositories.SurveyRepository;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;
import com.itLens.surveyApp.utils.responseEntities.ErrorApi;
import com.itLens.surveyApp.utils.responseEntities.SuccessApi;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/{id}")
@AllArgsConstructor
public class SaveAnswersController {

    private SurveyRepository surveyRepository;
    private SurveyEditionRepository surveyEditionRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    @GetMapping("/participate")
    public ApiResponse saveAnswerPerQuestion(@PathVariable String id, @Valid @RequestBody AnswerPerQuestion answers) {

        Map<String, String> errors = new HashMap<>();
        SurveyEdition surveyEdition = surveyEditionRepository.findById(id).orElse(null);
        if (surveyEdition == null) {
            errors.put("surveyEdition", "Survey Edition DOes found WIth This Is");
            return new ErrorApi(404, errors);
        }

        surveyEdition.getSubjects().forEach(
                subject -> {
                    subject.getQuestions().forEach(
                            question -> {

                                // Check If This Question Is The Same As The One Answered
                                if (question.getId().equals(answers.response().questionId())) {
                                    question.getAnswers().forEach(
                                            answer -> {

                                                answers.response().answerIds().forEach(
                                                        answerId -> {
                                                            if (answer.getId().equals(answerId)) {

                                                                question.setAnswerCount(question.getAnswerCount() + 1);
                                                                questionRepository.save(question);

                                                                // Increment Answers Selection By 1
                                                                answer.setSelectionCount(answer.getSelectionCount() + 1);
                                                                answerRepository.save(answer);
                                                            }
                                                        }
                                                );

                                            }
                                    );
                                }
                            }
                    );
                }
        );

        return new SuccessApi<>(200, "Answer saved successfully");
    }

}
