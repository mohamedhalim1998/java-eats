package com.mohamed.halim.javaeats.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;



public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {
    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.isNoneBlank(input) && input.length() > 8 && hasUpperLetters(input) && hasLowerLetters(input);
    }

    private boolean hasLowerLetters(String input) {
        return input.chars().anyMatch(Character::isLowerCase);
    }

    private boolean hasUpperLetters(String input) {
        return input.chars().anyMatch(Character::isUpperCase);
    }
}