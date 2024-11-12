package com.itLens.surveyApp.utils.existsAnnotation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class ExistsValidator implements ConstraintValidator<Exists, String> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> entity;

    @Override
    public void initialize(Exists constraintAnnotation) {
        this.entity = constraintAnnotation.entity();
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext context) {
        if (id == null) { return false; }

        Object found = entityManager.find(entity, id);
        return found != null;
    }

}
