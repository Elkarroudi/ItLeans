package com.itLens.surveyApp.controllers.v1;

import com.itLens.surveyApp.models.dtos.question.CreateQuestionDTO;
import com.itLens.surveyApp.models.dtos.question.QuestionDTO;
import com.itLens.surveyApp.models.dtos.subject.CreateSubjectDTO;
import com.itLens.surveyApp.models.dtos.subject.SubjectDTO;
import com.itLens.surveyApp.services.contracts.IQuestionService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/questions")
@AllArgsConstructor
public class QuestionController {

    private IQuestionService questionService;


    @GetMapping("/all/{id}")
    ApiResponse findAll(@PathVariable String id) {
        return questionService.findAll(id);
    }

    @GetMapping("/{id}")
    ApiResponse findById(@PathVariable String id) {
        return questionService.findById(id);
    }

    @PostMapping
    ApiResponse save(@Validated @RequestBody CreateQuestionDTO entityDTO) {
        return questionService.save(entityDTO);
    }

    @PutMapping("/{id}")
    ApiResponse update(@PathVariable("id") String id, @Validated @RequestBody QuestionDTO entityDTO) {
        return questionService.update(id, entityDTO);
    }

    @DeleteMapping("/{id}")
    ApiResponse delete(@PathVariable("id") String id) {
        return questionService.delete(id);
    }
}
