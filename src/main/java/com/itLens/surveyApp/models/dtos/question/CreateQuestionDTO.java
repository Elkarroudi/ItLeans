package com.itLens.surveyApp.models.dtos.question;

import com.itLens.surveyApp.models.enums.QuestionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateQuestionDTO(
        @NotBlank( message = "Question Title Is Required" )
        @Size(max = 250)
        String question,

        @NotNull( message = "Question Description Is Required" )
        QuestionType questionType,

        @NotBlank( message = "Question Subject Id Is Required" )
        String subjectId
) {

}
