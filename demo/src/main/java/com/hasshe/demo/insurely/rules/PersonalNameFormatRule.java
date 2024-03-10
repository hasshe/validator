package com.hasshe.demo.insurely.rules;

public class PersonalNameFormatRule implements Rules<String>{

    @Override
    public boolean applyRule(String name) {
        return name != null && !name.trim().isEmpty() && name.matches("[a-zA-ZåäöÅÄÖ ]+");
    }
    

}
