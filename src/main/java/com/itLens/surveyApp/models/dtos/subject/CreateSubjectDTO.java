package com.itLens.surveyApp.models.dtos.subject;

import com.itLens.surveyApp.models.entities.Owner;
import com.itLens.surveyApp.models.entities.Subject;
import com.itLens.surveyApp.models.entities.Survey;
import com.itLens.surveyApp.models.entities.SurveyEdition;
import com.itLens.surveyApp.utils.existsAnnotation.Exists;
import com.itLens.surveyApp.utils.uniqueAnnotation.UniqueField;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateSubjectDTO(
        @UniqueField(
                message = "Subject Name Already Exists",
                entityClass = Subject.class,
                fieldName = "title"
        )
        @NotBlank( message = "Survey Title Is Required" )
        @Size(max = 250)
        String title,

        @Exists(
                entity = SurveyEdition.class,
                message = "Survey With Id Not Found"
        )
        @NotBlank( message = "Survey Edition Id Is Required" )
        String surveyEditionId,

        String parentSubjectId
) {

}
