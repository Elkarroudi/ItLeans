package com.itLens.surveyApp.models.dtos.owner;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record OwnerDTO(
        @NotBlank( message = "Owner Id Is Required" )
        String id,

        @NotBlank( message = "Owner Name Is Required" )
        @Size(max = 250)
        String name
) {

}
