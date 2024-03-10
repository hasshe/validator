package com.hasshe.demo.insurely.rules;

public interface Rules<T> {

    boolean applyRule(T value);

}
