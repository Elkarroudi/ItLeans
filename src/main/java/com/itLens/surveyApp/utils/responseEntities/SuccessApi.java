package com.itLens.surveyApp.utils.responseEntities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class SuccessApi<ResponseDTO> extends ApiResponse{

    private final boolean success = true;

    @NotNull
    private ResponseDTO data;

    public SuccessApi(int httpStatus, ResponseDTO data) {
        super(httpStatus);
        this.data = data;
    }

}
