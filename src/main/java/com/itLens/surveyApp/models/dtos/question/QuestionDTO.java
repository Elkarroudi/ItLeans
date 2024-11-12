package com.itLens.surveyApp.models.dtos.question;

import com.itLens.surveyApp.models.entities.Question;
import com.itLens.surveyApp.models.enums.QuestionType;
import com.itLens.surveyApp.utils.existsAnnotation.Exists;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record QuestionDTO(
        @Exists(
                entity = Question.class,
                message = "Question With Id Not Found"
        )
        @NotBlank( message = "Answer Id Is Required" )
        String id,

        @NotBlank( message = "Answer Title Is Required" )
        @Size(max = 250)
        String question,

        @NotNull( message = "Answer Description Is Required" )
        QuestionType questionType,

        @NotBlank( message = "Answer Answers Count Is Required" )
        int answerCount
) {

}
