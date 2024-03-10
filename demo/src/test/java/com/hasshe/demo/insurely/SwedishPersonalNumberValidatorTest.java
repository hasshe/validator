package com.hasshe.demo.insurely;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hasshe.demo.insurely.validators.SwedishPersonalNumberValidator;

public class SwedishPersonalNumberValidatorTest {

    private SwedishPersonalNumberValidator validator;

    @BeforeEach
    void setup() {
        validator = new SwedishPersonalNumberValidator();
    }

    @Test
    void shouldReturnTrueForValidLongFormPersonalNumber() {
        var personalNumber = "19971128-4811";

        var result = validator.validate(personalNumber);

        assertTrue(result);
    }

    @Test
    void shouldReturnTrueForValidShortFormPersonalNumber() {
        var personalNumber = "971128-4811";

        var result = validator.validate(personalNumber);

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForInvalidShortFormPersonalNumber() {
        var personalNumber = "971128-4812";

        var result = validator.validate(personalNumber);

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseForInvalidLongFormPersonalNumber() {
        var personalNumber = "19971128-4812";

        var result = validator.validate(personalNumber);

        assertFalse(result);
    }

    @Test
    void shouldReturnTrueForValidAbove100PersonalNumber() {
        var personalNumber = "19201128+1231";

        var result = validator.validate(personalNumber);

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForInvalidAbove100PersonalNumber() {
        var personalNumber = "19201128+1232";

        var result = validator.validate(personalNumber);

        assertFalse(result);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfFormatIsInvalid() {
        var personalNumber = "19-9711284811";

        assertThrows(IllegalArgumentException.class, () -> validator.validate(personalNumber));
    }

}
