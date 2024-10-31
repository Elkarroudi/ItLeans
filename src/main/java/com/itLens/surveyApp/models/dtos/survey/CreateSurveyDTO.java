package com.itLens.surveyApp.models.dtos.survey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record CreateSurveyDTO(
        String title,
        String description,
        String ownerId
) {

}
