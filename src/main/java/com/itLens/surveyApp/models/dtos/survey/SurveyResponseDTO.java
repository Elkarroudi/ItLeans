package com.itLens.surveyApp.models.dtos.survey;

import com.itLens.surveyApp.models.dtos.owner.OwnerDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.SurveyEditionDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record SurveyResponseDTO(
        @NotBlank( message = "Survey Id Is Required" )
        String id,

        @NotBlank( message = "Survey Title Is Required" )
        @Size(max = 250)
        String title,

        @NotBlank( message = "Survey Description Is Required" )
        String description,

        @NotNull( message = "Survey Owner Is Required" )
        OwnerDTO owner,

        List<SurveyEditionDTO> surveyEditions
) {

}
