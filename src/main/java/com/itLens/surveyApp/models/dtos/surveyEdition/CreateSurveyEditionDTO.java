package com.itLens.surveyApp.models.dtos.surveyEdition;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CreateSurveyEditionDTO(
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
        int year,

        @NotBlank( message = "Survey Id Is Required" )
        String surveyId
) {

}
