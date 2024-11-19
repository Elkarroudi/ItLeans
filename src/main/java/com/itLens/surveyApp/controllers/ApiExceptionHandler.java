package com.itLens.surveyApp.controllers;

import com.itLens.surveyApp.utils.responseEntities.ErrorApi;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ErrorApi handleBadRequestException(BadRequestException ex, WebRequest request) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("type", "Bad Request Error");
        errorMap.put("error", ex.getMessage());

        return new ErrorApi(HttpStatus.BAD_REQUEST.value(), errorMap);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorApi handleValidationExceptions(final MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            final String fieldName = ((FieldError) error).getField();
            final String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ErrorApi(HttpStatus.BAD_REQUEST.value(), errors);
    }

    @ExceptionHandler(PersistenceException.class)
    public ErrorApi handlePersistenceException(PersistenceException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("type", "Persistence Error");
        errorMap.put("error", "A required field is missing or invalid: " + ex.getMessage());

        return new ErrorApi(HttpStatus.BAD_REQUEST.value(), errorMap);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorApi handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation -> {
            String field = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.put(field, message);
        });

        return new ErrorApi(HttpStatus.BAD_REQUEST.value(), errors);
    }



}
