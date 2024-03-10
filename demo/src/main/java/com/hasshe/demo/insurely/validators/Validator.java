package com.hasshe.demo.insurely.validators;

public interface Validator<T> {

    boolean validate(T value);

}
