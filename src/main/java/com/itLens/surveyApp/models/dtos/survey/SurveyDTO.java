package com.itLens.surveyApp.models.dtos.survey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record SurveyDTO(
        String id,
        String title,
        String description
) {

}
