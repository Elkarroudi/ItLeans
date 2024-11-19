package com.itLens.surveyApp.models.dtos.owner;

import com.itLens.surveyApp.models.entities.Owner;
import com.itLens.surveyApp.repositories.OwnerRepository;
import com.itLens.surveyApp.utils.uniqueAnnotation.UniqueField;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateOwnerDTO(
        @UniqueField(
                message = "Owner Name Already Exists",
                entityClass = Owner.class,
                fieldName = "name"
        )
        @NotBlank( message = "Owner Name Is Required" )
        @Size(max = 250, message = "Owner Name must not exceed 250 characters")
        String name
) {

}
