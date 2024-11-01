package com.itLens.surveyApp.models.dtos.answer;

import com.itLens.surveyApp.models.entities.Answer;
import com.itLens.surveyApp.utils.existsAnnotation.Exists;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AnswerDTO(
        @Exists(
                entity = Answer.class,
                message = "Answer With Id Not Found"
        )
        @NotBlank( message = "Answer Id Is Required" )
        String id,

        @NotBlank( message = "Answer Title Is Required" )
        @Size(max = 250)
        String answer,

        @NotBlank( message = "Answer Answers Count Is Required" )
        int selectionCount
) {

}
