package com.noxstudy.core.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.noxstudy.core.dto.RegisteredUser;

public class PasswordMatchesValidator implements ConstraintValidator<ValidPasswordMatches, Object>
{
    @Override
    public void initialize(ValidPasswordMatches passwordMatches)
    {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext)
    {
        RegisteredUser user = (RegisteredUser) o;
        return user.getPassword().equals(user.getConfirmedPassword());
    }
}