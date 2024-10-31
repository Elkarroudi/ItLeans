package com.itLens.surveyApp.models.dtos.subject;

import com.itLens.surveyApp.models.dtos.question.QuestionDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.SurveyEditionDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public record SubjectResponseDTO(
        String id,
        String title,
        SurveyEditionDTO surveyEdition,
        List<QuestionDTO> questions,
        List<SubjectResponseDTO> subSubjects,
        SubjectDTO parentSubject
) {

}
