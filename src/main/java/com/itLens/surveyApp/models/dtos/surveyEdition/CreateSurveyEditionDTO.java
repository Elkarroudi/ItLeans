package com.itLens.surveyApp.models.dtos.surveyEdition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record CreateSurveyEditionDTO(
        String creationDate,
        String startDate,
        String endDate,
        String year,
        String surveyId
) {

}
