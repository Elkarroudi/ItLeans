package com.itLens.surveyApp.utils.responseEntities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ErrorApi extends ApiResponse {

    @NotNull
    private String[] messages;

    private final boolean success = false;

    public ErrorApi(int httpStatus, String[] messages) {
        super(httpStatus);
        this.messages = messages;
    }
}
