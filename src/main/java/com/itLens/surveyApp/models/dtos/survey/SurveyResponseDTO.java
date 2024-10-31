package com.itLens.surveyApp.models.dtos.survey;

import com.itLens.surveyApp.models.dtos.owner.OwnerDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.SurveyEditionDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public record SurveyResponseDTO(
        String id,
        String title,
        String description,
        OwnerDTO owner,
        List<SurveyEditionDTO> surveyEditions
) {

}
