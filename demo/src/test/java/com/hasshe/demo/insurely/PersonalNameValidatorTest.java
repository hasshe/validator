package com.hasshe.demo.insurely;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hasshe.demo.insurely.validators.PersonalNameValidator;

public class PersonalNameValidatorTest {

    private PersonalNameValidator validator;

    @BeforeEach
    void setup() {
        validator = new PersonalNameValidator();
    }

    @Test
    void shouldReturnTrueIfNameIsValid() {
        var name = "Hassan";

        var result = validator.validate(name);

        assertTrue(result);
    }

    @Test
    void shouldReturnTrueIfNameIsValidWithSwedishLetter() {
        var name = "Håkan";

        var result = validator.validate(name);

        assertTrue(result);
    }

    @Test
    void shouldReturnTrueIfNameIsValidWithMultipleSwedishLetters() {
        var name = "Åäöskar";

        var result = validator.validate(name);

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseIfBlank() {
        var name = "";

        var result = validator.validate(name);

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseIfNull() {
        String name = null;

        var result = validator.validate(name);

        assertFalse(result);
    }

}
