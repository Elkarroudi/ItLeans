package com.itLens.surveyApp.models.dtos.answer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record AnswerDTO(
    String id,
    String answer,
    int selectionCount
) {

}
