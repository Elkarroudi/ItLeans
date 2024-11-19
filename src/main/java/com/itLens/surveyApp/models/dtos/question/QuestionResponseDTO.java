package com.itLens.surveyApp.models.dtos.question;

import com.itLens.surveyApp.models.dtos.answer.AnswerDTO;
import com.itLens.surveyApp.models.dtos.subject.SubjectDTO;
import com.itLens.surveyApp.models.enums.QuestionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record QuestionResponseDTO(
        @NotBlank( message = "Question Id Is Required" )
        String id,

        @NotBlank( message = "Question Title Is Required" )
        @Size(max = 250)
        String question,

        @NotNull( message = "Question Description Is Required" )
        QuestionType questionType,

        @NotBlank( message = "Question Answer Count Is Required" )
        int answerCount,

        @NotNull
        SubjectDTO subject,
        List<AnswerDTO> answers
) {

}
