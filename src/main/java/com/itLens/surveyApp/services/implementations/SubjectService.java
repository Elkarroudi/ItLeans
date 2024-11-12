package com.itLens.surveyApp.services.implementations;

import com.itLens.surveyApp.models.dtos.subject.CreateSubjectDTO;
import com.itLens.surveyApp.models.dtos.subject.SubjectDTO;
import com.itLens.surveyApp.models.dtos.subject.SubjectResponseDTO;
import com.itLens.surveyApp.models.entities.Subject;
import com.itLens.surveyApp.models.entities.Survey;
import com.itLens.surveyApp.models.entities.SurveyEdition;
import com.itLens.surveyApp.models.mappers.contracts.SubjectMapper;
import com.itLens.surveyApp.repositories.SubjectRepository;
import com.itLens.surveyApp.repositories.SurveyEditionRepository;
import com.itLens.surveyApp.services.contracts.ISubjectService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;
import com.itLens.surveyApp.utils.responseEntities.ErrorApi;
import com.itLens.surveyApp.utils.responseEntities.SuccessApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService implements ISubjectService {

    private SubjectRepository subjectRepository;
    private SurveyEditionRepository  surveyEditionRepository;
    private SubjectMapper subjectMapper;


    @Override
    public ApiResponse findAll(String id) {
        List<SubjectResponseDTO> subjectResponseDTO = subjectRepository.getAllBySurveyEditionId(id)
                .stream()
                .map(subjectMapper::toResponseDtoFromEntityWithAllRelationShips)
                .toList();

        return new SuccessApi<>(200, subjectResponseDTO);
    }

    @Override
    public ApiResponse findById(String id) {
        SubjectResponseDTO subject = subjectMapper.toResponseDtoFromEntityWithAllRelationShips(
                subjectRepository.findById(id).orElse(null)
        );

        if (subject == null) { return new ErrorApi(404, new String[]{"Subject not found with Id: " + id}); }
        return new SuccessApi<>(200, subject);
    }

    @Override
    public ApiResponse save(CreateSubjectDTO createSubjectDTO) {
        Subject subject = subjectMapper.toEntityFromCreateDto(createSubjectDTO);

        if (createSubjectDTO.parentSubjectId() != null) {
            Subject parentSubject = subjectRepository.findById(createSubjectDTO.parentSubjectId()).orElse(null);
            subject.setParentSubject(parentSubject);
        }

        subject.setSurveyEdition( surveyEditionRepository.findById( createSubjectDTO.surveyEditionId() ).orElse(null));
        Subject savedSubject = subjectRepository.save(subject);
        SubjectResponseDTO newSubject = subjectMapper.toResponseDtoFromEntityWithAllRelationShips(savedSubject);

        return new SuccessApi<>(200, newSubject);
    }

    @Override
    public ApiResponse update(String id, SubjectDTO subjectDTO) {
        Subject subject = subjectRepository.findById(id).orElse(null);
        subjectMapper.updateEntityFromDto(subjectDTO, subject);

        SubjectResponseDTO subjectResponseDTO = subjectMapper.toResponseDtoFromEntityWithAllRelationShips(
                subjectRepository.save(subject)
        );

        return new SuccessApi<>(200, subjectResponseDTO);
    }

    @Override
    public ApiResponse delete(String id) {
        Subject survey = subjectRepository.findById(id).orElse(null);
        if (survey == null) { return new ErrorApi(404, new String[]{"Survey not found"}); }

        subjectRepository.delete(survey);
        return new SuccessApi<>(200, "Subject deleted successfully");
    }

}
