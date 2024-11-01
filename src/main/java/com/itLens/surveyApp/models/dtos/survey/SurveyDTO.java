package com.itLens.surveyApp.models.dtos.survey;

import com.itLens.surveyApp.models.entities.Survey;
import com.itLens.surveyApp.utils.existsAnnotation.Exists;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SurveyDTO(
        @Exists(
                entity = Survey.class,
                message = "Survey With Id Not Found"
        )
        @NotBlank( message = "Survey Id Is Required" )
        String id,

        @NotBlank( message = "Survey Title Is Required" )
        @Size(max = 250)
        String title,

        @NotBlank( message = "Survey Description Is Required" )
        String description
) {

}
