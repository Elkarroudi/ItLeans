package com.itLens.surveyApp.controllers.v1;

import com.itLens.surveyApp.models.dtos.answer.AnswerDTO;
import com.itLens.surveyApp.models.dtos.answer.CreateAnswerDTO;
import com.itLens.surveyApp.services.contracts.IAnswerService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/answers")
@AllArgsConstructor
public class AnswerController {

    private IAnswerService answerService;


    @GetMapping("/all/{id}")
    ApiResponse findAll(@PathVariable String id) {
        return answerService.findAll(id);
    }

    @GetMapping("/{id}")
    ApiResponse findById(@PathVariable String id) {
        return answerService.findById(id);
    }

    @PostMapping
    ApiResponse save(@Validated @RequestBody CreateAnswerDTO entityDTO) {
        return answerService.save(entityDTO);
    }

    @PutMapping("/{id}")
    ApiResponse update(@PathVariable("id") String id, @Validated @RequestBody AnswerDTO entityDTO) {
        return answerService.update(id, entityDTO);
    }

    @DeleteMapping("/{id}")
    ApiResponse delete(@PathVariable("id") String id) {
        return answerService.delete(id);
    }

}
