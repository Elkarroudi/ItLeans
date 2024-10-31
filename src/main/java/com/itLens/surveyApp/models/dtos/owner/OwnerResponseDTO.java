package com.itLens.surveyApp.models.dtos.owner;

import com.itLens.surveyApp.models.dtos.survey.SurveyDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public record OwnerResponseDTO(
        @NotBlank( message = "Owner Id Is Required" )
        String id,

        @NotBlank( message = "Owner Name Is Required" )
        @Size(max = 250)
        String name,

        List<SurveyDTO> surveys
) {

}
