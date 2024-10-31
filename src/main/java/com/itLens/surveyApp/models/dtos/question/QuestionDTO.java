package com.itLens.surveyApp.models.dtos.question;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record QuestionDTO(
    String id,
    String question,
    String questionType,
    int answerCount
) {

}
