package com.itLens.surveyApp.controllers.v1;

import com.itLens.surveyApp.models.dtos.survey.CreateSurveyDTO;
import com.itLens.surveyApp.models.dtos.survey.SurveyDTO;
import com.itLens.surveyApp.services.contracts.ISurveyService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/surveys")
@AllArgsConstructor
public class SurveyController {

    private final ISurveyService surveyService;

    @GetMapping
    ApiResponse findAll() {
        return surveyService.findAll();
    }

    @GetMapping("/{id}")
    ApiResponse findById(@PathVariable String id) {
        return surveyService.findById(id);
    }

    @PostMapping
    ApiResponse save(@Valid @RequestBody CreateSurveyDTO entityDTO) {
        return surveyService.save(entityDTO);
    }

    @PutMapping("/{id}")
    ApiResponse update(@PathVariable("id") String id, @Valid @RequestBody SurveyDTO entityDTO) {
        return surveyService.update(id, entityDTO);
    }

    @DeleteMapping("/{id}")
    ApiResponse delete(@PathVariable("id") String id) {
        return surveyService.delete(id);
    }
}
