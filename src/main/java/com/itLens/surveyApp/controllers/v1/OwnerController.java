package com.itLens.surveyApp.controllers.v1;

import com.itLens.surveyApp.models.dtos.owner.CreateOwnerDTO;
import com.itLens.surveyApp.models.dtos.owner.OwnerDTO;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;
import com.itLens.surveyApp.services.contracts.IOwnerService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/owners")
@AllArgsConstructor
public class OwnerController {

    private IOwnerService ownerService;


    @GetMapping
    ApiResponse findAll() {
        return ownerService.findAll();
    }

    @GetMapping("/{id}")
    ApiResponse findById(@PathVariable String id) {
        return ownerService.findById(id);
    }

    @PostMapping
    ApiResponse save(@Validated @RequestBody CreateOwnerDTO entityDTO) {
        return ownerService.save(entityDTO);
    }

    @PutMapping("/{id}")
    ApiResponse update(@PathVariable("id") String id, @Validated @RequestBody OwnerDTO entityDTO) {
        return ownerService.update(id, entityDTO);
    }

    @DeleteMapping("/{id}")
    ApiResponse delete(@PathVariable("id") String id) {
        return ownerService.delete(id);
    }

}
