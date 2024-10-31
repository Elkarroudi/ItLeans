package com.itLens.surveyApp.models.dtos.owner;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record CreateOwnerDTO(
        @NotBlank( message = "Owner Name Is Required" )
        @Size(max = 250)
        String name
) {

}
