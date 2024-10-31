package com.itLens.surveyApp.models.dtos.subject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateSubjectDTO(
        @NotBlank( message = "Survey Title Is Required" )
        @Size(max = 250)
        String title,

        @NotBlank( message = "Survey Description Is Required" )
        String surveyEditionId,

        String parentSubjectId
) {

}
