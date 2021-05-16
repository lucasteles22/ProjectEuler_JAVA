package br.com.solution_002;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int MAX_VALUE = 4000000;

    public static void main(String[] args) {
        Integer answer = getAnswer();

        System.out.println(answer);
    }

    private static Integer getAnswer() {
        List<Integer> fibonacciList = getFibonacciSequence();

        return fibonacciList.stream()
                .filter(value -> (value % 2 == 0))
                .reduce(Integer::sum)
                .orElse(0);
    }

    private static List<Integer> getFibonacciSequence() {
        // Initial values for fibonacci sequence
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1); // F1 = 1;
        numbers.add(1); // F2 = 1

        int i = 2; // Starts F3
        Integer currentValue;

        do {
            currentValue = numbers.get(i - 1) + numbers.get(i - 2);
            numbers.add(currentValue);
            i++;
        } while (MAX_VALUE > currentValue + numbers.get(numbers.size() - 2));

        return numbers;
    }
}
