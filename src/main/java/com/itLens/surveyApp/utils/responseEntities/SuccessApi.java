package com.itLens.surveyApp.models.entities.responseEntities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SuccessApi<ResponseDTO> extends ApiResponse{

    @NotNull
    private ResponseDTO data;

}
