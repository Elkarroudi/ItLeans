package com.itLens.surveyApp.models.dtos.surveyEdition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record SurveyEditionDTO(
    String id,
    String creationDate,
    String startDate,
    String endDate,
    String year
) {

}
