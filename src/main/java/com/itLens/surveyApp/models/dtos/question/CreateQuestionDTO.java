package com.itLens.surveyApp.models.dtos.question;

import com.itLens.surveyApp.models.entities.Owner;
import com.itLens.surveyApp.models.entities.Question;
import com.itLens.surveyApp.models.entities.Subject;
import com.itLens.surveyApp.models.enums.QuestionType;
import com.itLens.surveyApp.utils.existsAnnotation.Exists;
import com.itLens.surveyApp.utils.uniqueAnnotation.UniqueField;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateQuestionDTO(
        @UniqueField(
                message = "Question Already Exists",
                entityClass = Question.class,
                fieldName = "question"
        )
        @NotBlank( message = "Question Title Is Required" )
        @Size(max = 250)
        String question,

        @NotNull( message = "Question Description Is Required" )
        QuestionType questionType,

        @Exists(
                entity = Subject.class,
                message = "Subject With Id Not Found"
        )
        @NotBlank( message = "Subject Id Is Required" )
        String subjectId
) {

}
