package com.hasshe.demo.insurely;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hasshe.demo.insurely.rules.PersonalNameFormatRule;
import com.hasshe.demo.insurely.rules.Rules;

public class PersonalNameFormatRuleTest {

    private Rules<String> rule;

    @BeforeEach
    void setup() {
        rule = new PersonalNameFormatRule();
    }

    @Test
    void shouldReturnFalseIfNameIsNull() {
        String name = null;

        var result = rule.applyRule(name);

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseIfNameIsBlank() {
        String name = " ";

        var result = rule.applyRule(name);

        assertFalse(result);
    }

    @Test
    void shouldReturnTrueIfNameIsValid() {
        String name = "Hassan";

        var result = rule.applyRule(name);

        assertTrue(result);
    }

    @Test
    void shouldReturnTrueIfNameContainsSwedishLiterals() {
        String name = "Åkeö";

        var result = rule.applyRule(name);

        assertTrue(result);
    }

}
