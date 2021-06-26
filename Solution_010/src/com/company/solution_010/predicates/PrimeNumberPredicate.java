package com.company.solution_010.predicates;

import java.util.function.Predicate;

import static com.company.solution_010.rules.PrimeNumberRules.isDivisibleBy;

public class PrimeNumberPredicate {

    public static Predicate<Long> isDivisibleByPredicate(Long number) {
        return x -> isDivisibleBy().check(number, x);
    }
}
