package com.hasshe.demo.insurely.validators;

import com.hasshe.demo.insurely.rules.PersonalNameFormatRule;
import com.hasshe.demo.insurely.rules.Rules;

public class PersonalNameValidator implements Validator<String>{

    private final Rules<String> formatRule;

    public PersonalNameValidator() {
        formatRule = new PersonalNameFormatRule();
    }

    @Override
    public boolean validate(String name) {
        return formatRule.applyRule(name);
    }

}
