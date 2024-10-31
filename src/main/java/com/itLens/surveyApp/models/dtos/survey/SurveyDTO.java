package com.itLens.surveyApp.models.dtos.survey;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record SurveyDTO(
        @NotBlank( message = "Survey Id Is Required" )
        String id,

        @NotBlank( message = "Survey Title Is Required" )
        @Size(max = 250)
        String title,

        @NotBlank( message = "Survey Description Is Required" )
        String description
) {

}
