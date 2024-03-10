package com.hasshe.demo.insurely.rules;

public class LuhnsAlgorithmRule implements Rules<String>{

    @Override
    public boolean applyRule(String value) {
        int checksum = getChecksum(value);
        int total = 0;

        for (int i = value.length() - 2; i >= 0; i --) {
            int digit = Character.getNumericValue(value.charAt(i));
            if (i % 2 == (value.length() % 2)) {
                digit *= 2;
                total += (digit / 10) + (digit % 10);
            } else total += digit;
        }

        return (total % 10) != 0 ? 10 - (total % 10) == checksum : checksum == 0;
    }

    private int getChecksum(String value) {
        return Character.getNumericValue(value.charAt(value.length() - 1));
    }
}
