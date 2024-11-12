package com.itLens.surveyApp.controllers;

import com.itLens.surveyApp.utils.responseEntities.ErrorApi;
import jakarta.validation.ConstraintViolationException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorApi> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ErrorApi errorResponse = new ErrorApi(
                HttpStatus.BAD_REQUEST.value(),
                new String[]{ex.getMessage()}
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle validation errors (e.g., @Validated errors in DTOs)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorApi> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        ErrorApi errorResponse = new ErrorApi(
                HttpStatus.BAD_REQUEST.value(),
                errorMessages.toArray(new String[0])  // Convert List<String> to String[]
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle ConstraintViolationException (for validation on path variables, etc.)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorApi> handleConstraintViolationException(ConstraintViolationException ex) {
        String[] errorMessages = ex.getConstraintViolations().stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .toArray(String[]::new);

        ErrorApi errorResponse = new ErrorApi(
                HttpStatus.BAD_REQUEST.value(),
                errorMessages
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle other general exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorApi> handleGeneralException(Exception ex, WebRequest request) {
        ErrorApi errorResponse = new ErrorApi(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new String[]{"An unexpected error occurred: " + ex.getMessage()}
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
