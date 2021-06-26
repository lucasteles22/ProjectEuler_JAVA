package com.company.solution_010;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private final static List<Long> primeNumbers = new ArrayList<>();
    private final static Long LIMIT = 2_000_000L;

    public static void main(String[] args) {
        Long answer = getAnswer();
        System.out.println(answer);
    }

    private static Long getAnswer() {
        for (Long number = 2L; number <= LIMIT; number++) {
            PrimeNumber primeNumberChecker = new PrimeNumberImpl(primeNumbers);

            if (primeNumberChecker.isPrime(number)) {
                System.out.println(number);
                primeNumbers.add(number);
            }
        }

        return primeNumbers.stream()
                .reduce(0L, Long::sum);
    }
}
