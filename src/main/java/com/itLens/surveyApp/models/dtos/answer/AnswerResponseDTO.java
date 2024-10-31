package com.itLens.surveyApp.models.dtos.answer;

import com.itLens.surveyApp.models.dtos.question.QuestionDTO;

public record AnswerResponseDTO(
    String id,
    String answer,
    int selectionCount,
    QuestionDTO question
) {

}
