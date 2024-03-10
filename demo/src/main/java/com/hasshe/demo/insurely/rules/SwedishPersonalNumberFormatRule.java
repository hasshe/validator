package com.hasshe.demo.insurely.rules;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class SwedishPersonalNumberFormatRule implements Rules<String> {

    private static final int SHORT_FORM = 6;
    private static final int LONG_FORM = 8;

    @Override
    public boolean applyRule(String personalNumber) {
        if (personalNumber.contains("+")) {
            if(is100OrOlder(personalNumber.split("\\+")[0], 1900)) {
                return Pattern.compile("\\d{8}\\+\\d{4}|\\d{6}\\+\\d{4}").matcher(personalNumber).matches();
            }
        }
        if (personalNumber.contains("-")) {
            if (!is100OrOlder(personalNumber.split("-")[0], 2000)) {
                return Pattern.compile("\\d{8}-\\d{4}|\\d{6}-\\d{4}").matcher(personalNumber).matches();
            }
        }
        return false;
    }

    private static boolean is100OrOlder(String personalNumber, int birthYearAdjustment) {
        Period age = calculateAge(personalNumber, birthYearAdjustment);
        return age.getYears() >= 100;
    }

    private static Period calculateAge(String personalNumber, int birthYearAdjustment) {
        int birthYear;
        int birthMonth;
        int birthDay;
        int currentYear = LocalDate.now().getYear();

        if (personalNumber.length() == SHORT_FORM) {
            birthYear = Integer.parseInt(personalNumber.substring(0, 2)) + birthYearAdjustment;
            birthMonth = Integer.parseInt(personalNumber.substring(2, 4));
            birthDay = Integer.parseInt(personalNumber.substring(4, 6));
        } else if (personalNumber.length() == LONG_FORM) {
            birthYear = Integer.parseInt(personalNumber.substring(0, 4));
            birthMonth = Integer.parseInt(personalNumber.substring(4, 6));
            birthDay = Integer.parseInt(personalNumber.substring(6, 8));
        } else {
            throw new IllegalArgumentException("Invalid personal number format");
        }

        LocalDate birthdate = LocalDate.of(birthYear, birthMonth, birthDay);
        LocalDate currentDate = LocalDate.of(currentYear, birthMonth, birthDay);

        return Period.between(birthdate, currentDate);
    }

}
