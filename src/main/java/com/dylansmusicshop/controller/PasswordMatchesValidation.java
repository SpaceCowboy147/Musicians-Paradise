package com.dylansmusicshop.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidation implements ConstraintValidator<RegistrationController.PasswordMatches, Object> {

    @Override
    public void initialize(RegistrationController.PasswordMatches constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}


