package com.noxstudy.validation;

public interface Validator<T> {

    void validate(T data) throws ValidationException;

    SupportType getSupportedType();
}