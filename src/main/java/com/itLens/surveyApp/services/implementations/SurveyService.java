package com.itLens.surveyApp.services.implementations;

import com.itLens.surveyApp.models.dtos.survey.CreateSurveyDTO;
import com.itLens.surveyApp.models.dtos.survey.SurveyDTO;
import com.itLens.surveyApp.models.dtos.survey.SurveyResponseDTO;
import com.itLens.surveyApp.models.entities.Owner;
import com.itLens.surveyApp.models.entities.Survey;
import com.itLens.surveyApp.models.mappers.contracts.SurveyMapper;
import com.itLens.surveyApp.repositories.OwnerRepository;
import com.itLens.surveyApp.repositories.SurveyRepository;
import com.itLens.surveyApp.services.contracts.ISurveyService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;
import com.itLens.surveyApp.utils.responseEntities.ErrorApi;
import com.itLens.surveyApp.utils.responseEntities.SuccessApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SurveyService implements ISurveyService {

    private final SurveyRepository surveyRepository;
    private final OwnerRepository ownerRepository;
    private final SurveyMapper surveyMapper;


    @Override
    public ApiResponse findAll() {
        List<SurveyResponseDTO> surveys =  surveyRepository.findAll()
                .stream()
                .map(surveyMapper::toResponseDtoFromEntityWithAllRelationShips)
                .toList();

        return new SuccessApi<>(200, surveys);
    }

    @Override
    public ApiResponse findById(String id) {
        Map<String, String> errors = new HashMap<>();
        SurveyResponseDTO survey = surveyMapper.toResponseDtoFromEntityWithAllRelationShips(
                surveyRepository.findById(id).orElse(null)
        );

        if (survey == null) {
            errors.put("Survey", "Survey Does Not Exists WIth This Id");
            return new ErrorApi(404, errors);
        }
        return new SuccessApi<>(200, survey);
    }

    @Override
    public ApiResponse save(CreateSurveyDTO createSurveyDTO) {
        Map<String, String> errors = new HashMap<>();
        Owner owner =  ownerRepository.findById( createSurveyDTO.ownerId() ).orElse(null);
        if (owner == null) {
            errors.put("Owner", "Owner Does Not Exists WIth This Id");
            return new ErrorApi(404, errors);
        }

        Survey survey = surveyMapper.toEntityFromCreateDto(createSurveyDTO);
        survey.setOwner(owner);

        Survey savedOwner = surveyRepository.save(survey);
        SurveyResponseDTO newSurvey = surveyMapper.toResponseDtoFromEntityWithAllRelationShips(savedOwner);

        return new SuccessApi<SurveyResponseDTO>(201, newSurvey);
    }

    @Override
    public ApiResponse update(String id, SurveyDTO surveyDTO) {
        Survey survey = surveyRepository.findById(id).orElse(null);
        surveyMapper.updateEntityFromDto(surveyDTO, survey);
        SurveyResponseDTO updatedSurvey = surveyMapper.toResponseDtoFromEntityWithAllRelationShips(
                surveyRepository.save(survey)
        );

        return new SuccessApi<SurveyResponseDTO>(200, updatedSurvey);
    }

    @Override
    public ApiResponse delete(String id) {
        Map<String, String> errors = new HashMap<>();
        Survey survey = surveyRepository.findById(id).orElse(null);
        if (survey == null) {
            errors.put("Survey", "Survey Does Not Exists WIth This Id");
            return new ErrorApi(404, errors);
        }

        surveyRepository.delete(survey);
        return new SuccessApi<>(200, "Survey deleted successfully");
    }

}
