package br.com.solution_005;

import java.util.NoSuchElementException;

public class Main {

    private final static Long MIN_DIVISOR = 1L;
    private final static Long MAX_DIVISOR = 20L;

    public static void main(String[] args) {
        Long answer = getAnswer();
        System.out.println(answer);
    }

    private static Long getAnswer() {
        for (Long dividend = MAX_DIVISOR + 1; dividend <= Long.MAX_VALUE; dividend++) {
            for (Long divisor = MIN_DIVISOR; divisor <= MAX_DIVISOR; divisor++) {
                if (dividend % divisor != 0) {
                    break;
                }

                // Condition break
                if (divisor.equals(MAX_DIVISOR)) {
                    return dividend;
                }
            }
        }

        throw new NoSuchElementException();
    }
}
