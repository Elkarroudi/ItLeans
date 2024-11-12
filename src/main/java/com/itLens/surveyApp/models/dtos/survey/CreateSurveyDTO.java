package com.itLens.surveyApp.models.dtos.survey;

import com.itLens.surveyApp.models.entities.Owner;
import com.itLens.surveyApp.utils.existsAnnotation.Exists;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateSurveyDTO(
        @NotBlank( message = "Survey Title Is Required" )
        @Size(max = 250)
        String title,

        @NotBlank( message = "Survey Description Is Required" )
        String description,

        @Exists(
                entity = Owner.class,
                message = "Owner With Id Not Found"
        )
        @NotBlank( message = "Survey Owner Id Is Required" )
        String ownerId
) {

}
