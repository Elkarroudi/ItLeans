package com.itLens.surveyApp.models.dtos;

import java.util.List;

public record AnswerPerQuestion(
        String answerType,
        EmbeddedResponse response
) {

}
