package br.com.solution_004;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final static Integer MAX_NUMBER = 999;
    private final static Integer MIN_NUMBER = 100;

    public static void main(String[] args) {
        Integer answer = getAnswer();
        System.out.println(answer);
    }

    private static Integer getAnswer() {
        List<Integer> palindromes = new ArrayList<>();
        for (int i = MAX_NUMBER; i >= MIN_NUMBER; i--) {
            for (int j = i; j >= MIN_NUMBER; j--) {
                Integer mult = i * j;
                List<Integer> digits = doTransformToListOfDigits(mult);
                List<Integer> reverseDigits = doReverseList(digits);

                if (digits.equals(reverseDigits)) {
                    String num = doConvertListToString(digits);
                    palindromes.add(Integer.valueOf(num));
                }
            }
        }
        return palindromes.parallelStream()
                .max(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

    private static List<Integer> doTransformToListOfDigits(Integer number) {
        return String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<Integer> doReverseList(List<Integer> original) {
        List<Integer> list = new ArrayList<>(original);
        Collections.reverse(list);

        return list;
    }

    private static String doConvertListToString(List<Integer> digits) {
        return digits.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
