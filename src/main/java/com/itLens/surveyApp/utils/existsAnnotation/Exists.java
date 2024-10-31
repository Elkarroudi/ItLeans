package com.itLens.surveyApp.utils.existsAnnotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistsValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Exists {

    String message() default "ID does not exist in the database";
    Class<?> entity();

}
