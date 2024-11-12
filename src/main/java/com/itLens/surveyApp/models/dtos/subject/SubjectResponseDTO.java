package com.itLens.surveyApp.models.dtos.subject;

import com.itLens.surveyApp.models.dtos.question.QuestionDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.SurveyEditionDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record SubjectResponseDTO(
        @NotBlank( message = "Survey Id Is Required" )
        String id,

        @NotBlank( message = "Survey Title Is Required" )
        @Size(max = 250)
        String title,

        @NotNull
        SurveyEditionDTO surveyEdition,

        List<SubjectResponseDTO> subSubjects,
        SubjectDTO parentSubject
) {

}
