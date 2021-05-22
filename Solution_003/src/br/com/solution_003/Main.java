package br.com.solution_003;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    private static final Long NUMBER = 600851475143L;

    public static void main(String[] args) {
        Long answer = getAnswer();
        System.out.println(answer);
    }

    private static Long getAnswer() {
        List<Long> factors = new ArrayList<>();

        Long factor = 2L;
        Long divisor = NUMBER;

        while (divisor != 1 && factor <= NUMBER / 2) {
            if (divisor % factor == 0) {
                divisor = divisor / factor;
                factors.add(factor);
            } else {
                factor++;
            }
        }

        return factors.parallelStream()
                .max(Long::compare)
                .orElseThrow(NoSuchElementException::new);
    }
}
