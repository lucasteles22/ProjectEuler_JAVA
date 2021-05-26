package br.com.solution_006;

import java.util.stream.IntStream;

public class Main {

    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 100;
    private static final Integer POW = 2;

    public static void main(String[] args) {
        Integer answer = getAnswer();
        System.out.println(answer);
    }

    private static Integer getAnswer() {
        Integer sumOfTheSquares = getSumOfTheSquares();
        Integer squareOfSum = getSquareOfSum();

        return squareOfSum - sumOfTheSquares;
    }

    private static Integer getSumOfTheSquares() {
        // [1, 101)
        return IntStream.range(MIN_NUMBER, MAX_NUMBER + 1)
                .parallel()
                .map(x -> (int) Math.pow(x, POW))
                .reduce(0, Integer::sum);
    }

    private static Integer getSquareOfSum() {
        // [1, 101)
        Integer sum = IntStream.range(MIN_NUMBER, MAX_NUMBER + 1)
                .parallel()
                .reduce(0, Integer::sum);

       return (int) Math.pow(sum, POW);
    }
}
