package br.com.solution_007;

import java.util.List;

import static br.com.solution_007.predicates.prime_numbers.PrimeNumberPredicates.isDivisibleByPredicate;
import static br.com.solution_007.rules.prime_numbers.PrimeNumberRules.isDivisibleBy;
import static br.com.solution_007.rules.prime_numbers.PrimeNumberRules.isEqualTo;

public class PrimeNumberImpl implements PrimeNumber {
    private final Long TWO = 2L;
    private final Long THREE = 3L;
    private final Long FIVE = 5L;
    private final Long SEVEN = 7L;

    private final List<Long> primeNumbers;

    public PrimeNumberImpl(List<Long> primeNumbers) {
        this.primeNumbers = primeNumbers;
    }

    @Override
    public Boolean isPrime(Long number) {
        if (isEqualTo().check(number, TWO) ||
                isEqualTo().check(number, THREE) ||
                isEqualTo().check(number, FIVE) ||
                isEqualTo().check(number, SEVEN)) {
            return true;
        }

        return !(isDivisibleBy().check(number, TWO) ||
                isDivisibleBy().check(number, THREE) ||
                isDivisibleBy().check(number, FIVE) ||
                isDivisibleBy().check(number, SEVEN) ||
                this.primeNumbers.stream().anyMatch(isDivisibleByPredicate(number)));
    }
}
