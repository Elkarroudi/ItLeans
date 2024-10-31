package com.itLens.surveyApp.models.dtos.surveyEdition;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public record SurveyEditionDTO(
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
