package com.itLens.surveyApp.controllers.v1;

import com.itLens.surveyApp.models.dtos.subject.CreateSubjectDTO;
import com.itLens.surveyApp.models.dtos.subject.SubjectDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.CreateSurveyEditionDTO;
import com.itLens.surveyApp.models.dtos.surveyEdition.SurveyEditionDTO;
import com.itLens.surveyApp.services.contracts.ISubjectService;
import com.itLens.surveyApp.services.implementations.SubjectService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subjects")
@AllArgsConstructor
public class SubjectController {

    private ISubjectService subjectService;


    @GetMapping("/all/{id}")
    ApiResponse findAll(@PathVariable String id) {
        return subjectService.findAll(id);
    }

    @GetMapping("/{id}")
    ApiResponse findById(@PathVariable String id) {
        return subjectService.findById(id);
    }

    @PostMapping
    ApiResponse save(@Validated @RequestBody CreateSubjectDTO entityDTO) {
        return subjectService.save(entityDTO);
    }

    @PutMapping("/{id}")
    ApiResponse update(@PathVariable("id") String id, @Validated @RequestBody SubjectDTO entityDTO) {
        return subjectService.update(id, entityDTO);
    }

    @DeleteMapping("/{id}")
    ApiResponse delete(@PathVariable("id") String id) {
        return subjectService.delete(id);
    }

}
