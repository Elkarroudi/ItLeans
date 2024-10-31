package com.itLens.surveyApp.models.dtos.owner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record CreateOwnerDTO(
        String name
) {

}
