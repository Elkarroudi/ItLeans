package com.itLens.surveyApp.models.dtos.owner;

import com.itLens.surveyApp.models.dtos.survey.SurveyDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public record OwnerResponseDTO(
        String id,
        String name,
        List<SurveyDTO> surveys
) {

}
