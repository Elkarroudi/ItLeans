package com.itLens.surveyApp.models.dtos.surveyEdition;

import com.itLens.surveyApp.models.entities.SurveyEdition;
import com.itLens.surveyApp.utils.existsAnnotation.Exists;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record SurveyEditionDTO(
        @Exists(
                entity = SurveyEdition.class,
                message = "Survey Edition With Id Not Found"
        )
        @NotBlank( message = "Owner Id Is Required" )
        String id,

        @NotNull( message = "Creation Date Is Required" )
        LocalDate creationDate,

        @NotNull( message = "Start Date Is Required" )
        @FutureOrPresent
        LocalDate startDate,

        @NotNull( message = "End Date Is Required" )
        @Future
        LocalDate endDate,

        @NotNull( message = "Year Is Required" )
        @Min(2024)
        int year
) {

}
