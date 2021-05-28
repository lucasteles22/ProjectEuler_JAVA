package br.com.solution_007.rules.prime_numbers;

import br.com.solution_007.rules.Rule;

public class PrimeNumberRules {
    public static Rule isEqualTo() {
        return Long::equals;
    }

    public static Rule isDivisibleBy() {
        return (dividend, divisor) -> dividend % divisor == 0;
    }
}
