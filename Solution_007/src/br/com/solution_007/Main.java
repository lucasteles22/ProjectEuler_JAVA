package br.com.solution_007;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static Integer nthNumber = 10001;
    private final static List<Long> primeNumbers = new ArrayList<>();

    public static void main(String[] args) {
        Long answer = getAnswer();
        System.out.println(answer);
    }

    private static Long getAnswer() {
        for (Long number = 2L; ; number++) {
            PrimeNumber primeNumberChecker = new PrimeNumberImpl(primeNumbers);

            if (primeNumberChecker.isPrime(number)) {
                primeNumbers.add(number);
                if (primeNumbers.size() == nthNumber) {
                    return number;
                }
            }
        }
    }
}
