package com.itLens.surveyApp.models.dtos.subject;

import com.itLens.surveyApp.models.entities.Subject;
import com.itLens.surveyApp.utils.existsAnnotation.Exists;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SubjectDTO(
        @Exists(
                entity = Subject.class,
                message = "Subject With Id Not Found"
        )
        @NotBlank( message = "Survey Id Is Required" )
        String id,

        @NotBlank( message = "Survey Title Is Required" )
        @Size(max = 250)
        String title
) {

}
