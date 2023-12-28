package com.bernardo.spring.issues.sof.questions.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidMaxMinDoubleValidator.class)
public @interface ValidMaxMinDouble {
    String message() default "The maximum value must be greater than or equal to the minimum value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String maxFieldName();

    String minFieldName();

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        ValidMaxMinDouble[] value();
    }
}
