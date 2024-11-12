package com.itLens.surveyApp.controllers.v1;

import com.itLens.surveyApp.models.dtos.owner.CreateOwnerDTO;
import com.itLens.surveyApp.models.dtos.owner.OwnerDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.CreateSurveyEditionDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.SurveyEditionDTO;
import com.itLens.surveyApp.services.contracts.ISurveyEditionService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/survey-editions")
@AllArgsConstructor
public class SurveyEditionController {

    private ISurveyEditionService surveyEditionService;


    @GetMapping("/all/{id}")
    ApiResponse findAll(@PathVariable String id) {
        return surveyEditionService.findAll(id);
    }

    @GetMapping("/{id}")
    ApiResponse findById(@PathVariable String id) {
        return surveyEditionService.findById(id);
    }

    @PostMapping
    ApiResponse save(@Validated @RequestBody CreateSurveyEditionDTO entityDTO) {
        return surveyEditionService.save(entityDTO);
    }

    @PutMapping("/{id}")
    ApiResponse update(@PathVariable("id") String id, @Validated @RequestBody SurveyEditionDTO entityDTO) {
        return surveyEditionService.update(id, entityDTO);
    }

    @DeleteMapping("/{id}")
    ApiResponse delete(@PathVariable("id") String id) {
        return surveyEditionService.delete(id);
    }

}
