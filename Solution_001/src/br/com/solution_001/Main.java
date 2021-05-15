package br.com.solution_001;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {

    private static final int CEILING_VALUE = 1000;

    public static void main(String[] args) {
        Integer answer = getAnswer();

        System.out.println(answer);
    }

    private static Integer getAnswer() {
        return IntStream.range(0, CEILING_VALUE)
                .filter(value -> (value % 3 == 0) || (value % 5 == 0))
                .reduce(Integer::sum)
                .orElse(0);
    }

}
