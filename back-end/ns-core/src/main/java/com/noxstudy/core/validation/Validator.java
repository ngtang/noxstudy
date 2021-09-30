package com.noxstudy.core.validation;

public interface Validator<T>
{
    public void validate(T t) throws ValidationException;
}
