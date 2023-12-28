package com.bernardo.spring.issues.sof.questions.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class ValidMaxMinDoubleValidator implements ConstraintValidator<ValidMaxMinDouble, Object> {
    private String maxFieldName;
    private String minFieldName;
    private String message;

    @Override
    public void initialize(ValidMaxMinDouble constraintAnnotation) {
        this.maxFieldName = constraintAnnotation.maxFieldName();
        this.minFieldName = constraintAnnotation.minFieldName();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Double maxValue = (Double) new BeanWrapperImpl(value).getPropertyValue(maxFieldName);
        Double minValue = (Double) new BeanWrapperImpl(value).getPropertyValue(minFieldName);

        if (maxValue == null || minValue == null) {
            return false;
        }

        boolean valid = maxValue >= minValue;
        if (!valid && !message.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        }

        return valid;
    }
}
