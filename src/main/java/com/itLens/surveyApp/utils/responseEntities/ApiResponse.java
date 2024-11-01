package com.itLens.surveyApp.utils.responseEntities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ApiResponse {

    @NotNull
    private int httpStatus;

    private final LocalDateTime timestamp = LocalDateTime.now();

}
