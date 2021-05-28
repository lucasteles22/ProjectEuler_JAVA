package br.com.solution_007.predicates.prime_numbers;

import java.util.function.Predicate;

import static br.com.solution_007.rules.prime_numbers.PrimeNumberRules.isDivisibleBy;

public class PrimeNumberPredicates {
    public static Predicate<Long> isDivisibleByPredicate(Long number) {
        return x -> isDivisibleBy().check(number, x);
    }
}
