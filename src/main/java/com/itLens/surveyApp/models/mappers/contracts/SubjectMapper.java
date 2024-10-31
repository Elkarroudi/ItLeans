package com.itLens.surveyApp.models.mappers.contracts;

import com.itLens.surveyApp.models.dtos.subject.SubjectDTO;
import com.itLens.surveyApp.models.dtos.subject.SubjectResponseDTO;
import com.itLens.surveyApp.models.entities.Subject;
import com.itLens.surveyApp.models.mappers.IGenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper extends IGenericMapper<Subject, SubjectDTO, SubjectResponseDTO> {
}
