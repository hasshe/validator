package com.hasshe.demo.insurely;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hasshe.demo.insurely.rules.LuhnsAlgorithmRule;
import com.hasshe.demo.insurely.rules.Rules;

public class LuhnsAlgorithmRuleTest {

    private Rules<String> rule;

    @BeforeEach
    void setup() {
        rule = new LuhnsAlgorithmRule();
    }

    @Test
    void shouldReturnTrueForValidChecksum() {
        var input = "9711284811";

        var result = rule.applyRule(input);

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForInValidChecksum() {
        var input = "9711284812";

        var result = rule.applyRule(input);

        assertFalse(result);
    }

}
