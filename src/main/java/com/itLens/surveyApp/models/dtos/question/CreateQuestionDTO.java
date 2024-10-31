package com.itLens.surveyApp.models.dtos.question;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record CreateQuestionDTO(
        String question,
        String type,
        String subjectId
) {

}
