package com.itLens.surveyApp.models.dtos;

import java.util.List;

public record EmbeddedResponse(
        String questionId,
        List<String> answerIds
) {
}
