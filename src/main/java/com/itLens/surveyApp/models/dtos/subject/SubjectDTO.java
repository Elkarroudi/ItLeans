package com.itLens.surveyApp.models.dtos.subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record SubjectDTO(
    String id,
    String title
) {

}
