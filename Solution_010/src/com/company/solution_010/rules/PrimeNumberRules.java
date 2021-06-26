package com.company.solution_010.rules;

public class PrimeNumberRules {

    public static Rule isEqualTo() {
        return Long::equals;
    }

    public static Rule isDivisibleBy() {
        return (dividend, divisor) -> dividend % divisor == 0;
    }
}
