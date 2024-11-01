package com.itLens.surveyApp.models.dtos.owner;

import com.itLens.surveyApp.models.entities.Owner;
import com.itLens.surveyApp.utils.existsAnnotation.Exists;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record OwnerDTO(
        @Exists(
                entity = Owner.class,
                message = "Owner With Id Not Found"
        )
        @NotBlank( message = "Owner Id Is Required" )
        String id,

        @NotBlank( message = "Owner Name Is Required" )
        @Size(max = 250)
        String name
) {

}
