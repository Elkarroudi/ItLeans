package com.itLens.surveyApp.models.dtos.question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record QuestionDTO(
        @NotBlank( message = "Answer Id Is Required" )
        String id,

        @NotBlank( message = "Answer Title Is Required" )
        @Size(max = 250)
        String question,

        @NotNull( message = "Answer Description Is Required" )
        String questionType,

        @NotBlank( message = "Answer Answers Count Is Required" )
        int answerCount
) {

}
