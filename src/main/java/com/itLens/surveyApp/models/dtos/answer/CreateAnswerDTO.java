package com.itLens.surveyApp.models.dtos.answer;

import com.itLens.surveyApp.models.entities.Answer;
import com.itLens.surveyApp.models.entities.Owner;
import com.itLens.surveyApp.models.entities.Question;
import com.itLens.surveyApp.utils.existsAnnotation.Exists;
import com.itLens.surveyApp.utils.uniqueAnnotation.UniqueField;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAnswerDTO(
        @UniqueField(
                message = "Answer Name Already Exists",
                entityClass = Answer.class,
                fieldName = "answer"
        )
        @NotBlank( message = "Answer Title Is Required" )
        @Size(max = 250)
        String answer,

        @Exists(
                entity = Question.class,
                message = "Question With Id Not Found"
        )
        @NotBlank( message = " Question Id Is Required" )
        String questionId
) {

}
