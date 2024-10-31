package com.itLens.surveyApp.models.dtos.answer;

import com.itLens.surveyApp.models.dtos.question.QuestionDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record AnswerResponseDTO(
    String id,
    String answer,
    int selectionCount,
    QuestionDTO question
) {

}
