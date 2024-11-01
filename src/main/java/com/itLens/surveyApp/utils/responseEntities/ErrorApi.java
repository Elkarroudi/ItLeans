package com.itLens.surveyApp.models.entities.responseEntities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorApi extends ApiResponse {

    @NotNull
    private String[] messages;

}
