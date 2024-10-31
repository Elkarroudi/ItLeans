package com.itLens.surveyApp.models.dtos.answer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record CreateAnswerDTO(
        @NotBlank( message = "Answer Title Is Required" )
        @Size(max = 250)
        String answer,

        @NotBlank( message = "Answer Question Id Is Required" )
        String questionId
) {

}
