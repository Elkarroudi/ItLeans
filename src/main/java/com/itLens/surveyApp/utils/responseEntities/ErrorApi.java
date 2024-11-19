package com.itLens.surveyApp.utils.responseEntities;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Map;

@Getter
public class ErrorApi extends ApiResponse {

    @NotNull
    private Map<String, String> errors;

    private final boolean success = false;

    public ErrorApi(int httpStatus, Map<String, String> errors) {
        super(httpStatus);
        this.errors = errors;
    }
}
