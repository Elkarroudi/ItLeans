package com.itLens.surveyApp.services.implementations;

import com.itLens.surveyApp.models.dtos.owner.OwnerResponseDTO;
import com.itLens.surveyApp.models.dtos.survey.SurveyResponseDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.CreateSurveyEditionDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.SurveyEditionDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.SurveyEditionResponseDTO;
import com.itLens.surveyApp.models.entities.Survey;
import com.itLens.surveyApp.models.entities.SurveyEdition;
import com.itLens.surveyApp.models.mappers.contracts.SurveyEditionMapper;
import com.itLens.surveyApp.repositories.SurveyEditionRepository;
import com.itLens.surveyApp.repositories.SurveyRepository;
import com.itLens.surveyApp.services.contracts.ISurveyEditionService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;
import com.itLens.surveyApp.utils.responseEntities.ErrorApi;
import com.itLens.surveyApp.utils.responseEntities.SuccessApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SurveyEditionService implements ISurveyEditionService {

    private SurveyEditionRepository surveyEditionRepository;
    private SurveyRepository surveyRepository;
    private SurveyEditionMapper surveyEditionMapper;


    @Override
    public ApiResponse findAll(String id) {
        List<SurveyEditionResponseDTO> surveyEditionResponseDTO = surveyEditionRepository.getAllBySurveyId(id)
                .stream()
                .map(surveyEditionMapper::toResponseDtoFromEntityWithAllRelationShips)
                .toList();

        return new SuccessApi<>(200, surveyEditionResponseDTO);
    }

    @Override
    public ApiResponse findById(String id) {
        SurveyEditionResponseDTO survey = surveyEditionMapper.toResponseDtoFromEntityWithAllRelationShips(
                surveyEditionRepository.findById(id).orElse(null)
        );

        if (survey == null) { return new ErrorApi(404, new String[]{"Survey Edition not found with Id: " + id}); }
        return new SuccessApi<>(200, survey);
    }

    @Override
    public ApiResponse save(CreateSurveyEditionDTO createSurveyEditionDTO) {
        SurveyEdition surveyEdition = surveyEditionMapper.toEntityFromCreateDto(createSurveyEditionDTO);
        surveyEdition.setSurvey(
                surveyRepository.findById(
                        createSurveyEditionDTO.surveyId()
                ).orElse(null)
        );

        SurveyEdition savedSurveyEdition = surveyEditionRepository.save(surveyEdition);
        SurveyEditionResponseDTO surveyEditionResponse = surveyEditionMapper.toResponseDtoFromEntityWithAllRelationShips(savedSurveyEdition);

        return new SuccessApi<>(200, surveyEditionResponse);
    }

    @Override
    public ApiResponse update(String id, SurveyEditionDTO surveyEditionDTO) {
        SurveyEdition surveyEdition = surveyEditionRepository.findById(id).orElse(null);
        SurveyEdition updatedSurveyEdition = surveyEditionMapper.updateEntityFromDto(surveyEditionDTO, surveyEdition);

        SurveyEditionResponseDTO surveyEditionResponseDTO = surveyEditionMapper.toResponseDtoFromEntityWithAllRelationShips(
                surveyEditionRepository.save(updatedSurveyEdition)
        );

        return new SuccessApi<>(200, surveyEditionResponseDTO);
    }

    @Override
    public ApiResponse delete(String id) {
        SurveyEdition surveyEdition = surveyEditionRepository.findById(id).orElse(null);
        if (surveyEdition == null) { return new ErrorApi(404, new String[]{"Survey Edition not found with Id: " + id}); }

        surveyEditionRepository.delete(surveyEdition);
        return new SuccessApi<>(200, new String[]{"Survey Edition deleted successfully"});
    }
}
