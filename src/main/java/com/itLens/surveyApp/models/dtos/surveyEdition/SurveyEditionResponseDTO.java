package com.itLens.surveyApp.models.dtos.surveyEdition;

import com.itLens.surveyApp.models.dtos.subject.SubjectDTO;
import com.itLens.surveyApp.models.dtos.survey.SurveyDTO;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record SurveyEditionResponseDTO(
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
        int year,

        @NotNull
        SurveyDTO survey,

        List<SubjectDTO> subjects
) {

}
