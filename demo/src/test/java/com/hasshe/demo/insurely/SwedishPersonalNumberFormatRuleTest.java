package com.hasshe.demo.insurely;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DateTimeException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hasshe.demo.insurely.rules.Rules;
import com.hasshe.demo.insurely.rules.SwedishPersonalNumberFormatRule;

public class SwedishPersonalNumberFormatRuleTest {

    private Rules<String> rule;

    @BeforeEach
    void setup() {
        rule = new SwedishPersonalNumberFormatRule();
    }

    @Test
    void shouldReturnTrueForValidLongFormat() {
        var personalNumber = "19971128-1234";

        var result = rule.applyRule(personalNumber);

        assertTrue(result);
    }

    @Test
    void shouldReturnTrueForValidShortFormat() {
        var personalNumber = "971128-1234";

        var result = rule.applyRule(personalNumber);

        assertTrue(result);
    }

    @Test
    void shouldReturnTrueForValidLongFormatAbove100Years() {
        var personalNumber = "19201128+1234";

        var result = rule.applyRule(personalNumber);

        assertTrue(result);
    }

    @Test
    void shouldReturnTrueForValidShortFormatAbove100Years() {
        var personalNumber = "201128+1234";

        var result = rule.applyRule(personalNumber);

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForValidFromatButInvalidAge() {
        var personalNumber = "123456-1234";

        assertThrows(DateTimeException.class, () -> rule.applyRule(personalNumber));
    }

}
