package com.company.solution_009;

import java.util.NoSuchElementException;

public class Main {

    private static final Integer LIMIT = 1000;

    public static void main(String[] args) {
        Long answer = getAnswer();
        System.out.println(answer);
    }

    private static Long getAnswer() {
        for (Integer a = 1; a <= LIMIT; a++) {
            for (Integer b = 1; b <= LIMIT; b++) {
                Integer c = LIMIT - a - b;

                if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                    return a.longValue() * b.longValue() * c.longValue();
                }
            }
        }

        throw new NoSuchElementException();
    }
}
