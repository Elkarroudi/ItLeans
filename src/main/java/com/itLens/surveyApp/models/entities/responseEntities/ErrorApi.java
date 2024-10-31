package com.itLens.surveyApp.models.entities.responseEntities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorApi {

    @NotNull
    private String[] messages;

    @NotNull
    private int httpStatus;

    private final boolean success = true;
    private final LocalDateTime timestamp = LocalDateTime.now();

}
