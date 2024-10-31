package com.itLens.surveyApp.models.dtos.question;

import com.itLens.surveyApp.models.dtos.answer.AnswerDTO;
import com.itLens.surveyApp.models.dtos.subject.SubjectDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public record QuestionResponseDTO(
        String id,
        String question,
        String questionType,
        int answerCount,
        SubjectDTO subject,
        List<AnswerDTO> answers
) {

}
