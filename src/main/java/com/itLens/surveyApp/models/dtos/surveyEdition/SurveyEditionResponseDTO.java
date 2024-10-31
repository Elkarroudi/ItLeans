package com.itLens.surveyApp.models.dtos.surveyEdition;

import com.itLens.surveyApp.models.dtos.subject.SubjectDTO;
import com.itLens.surveyApp.models.dtos.survey.SurveyDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public record SurveyEditionResponseDTO(
        String id,
        String creationDate,
        String startDate,
        String endDate,
        String year,
        SurveyDTO survey,
        List<SubjectDTO> subjects
) {

}
