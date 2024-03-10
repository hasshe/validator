package com.hasshe.demo.insurely.validators;

import com.hasshe.demo.insurely.rules.LuhnsAlgorithmRule;
import com.hasshe.demo.insurely.rules.Rules;
import com.hasshe.demo.insurely.rules.SwedishPersonalNumberFormatRule;

public class SwedishPersonalNumberValidator implements Validator<String>{

    private Rules<String> luhnRule;
    private Rules<String> formattingRule;
    private static final int SHORT_FORM = 11;
    private static final int LONG_FORM = 13;

        public SwedishPersonalNumberValidator() {
            luhnRule = new LuhnsAlgorithmRule();
            formattingRule = new SwedishPersonalNumberFormatRule();
    }

    @Override
    public boolean validate(String personalNumber) {
        if (personalNumber.length() == SHORT_FORM && isValidFormat(personalNumber)) {
            return luhnRule.applyRule(cleanupValue(personalNumber));
        }
        if (personalNumber.length() == LONG_FORM && isValidFormat(personalNumber)) {
            return luhnRule.applyRule(cleanupAndSubstring(personalNumber));
        }
        return false;
    }

    private String cleanupAndSubstring(String personalNumber) {
        return cleanupValue(personalNumber).substring(2, personalNumber.length()-1);
    }

    private String cleanupValue(String personalNumber) {
        return personalNumber.replaceAll("[-+]", "");
    }

    private boolean isValidFormat(String personalNumber) {
        return formattingRule.applyRule(personalNumber);
    }

}
