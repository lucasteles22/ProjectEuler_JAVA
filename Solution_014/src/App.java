public class App {
    public static void main(String[] args) throws Exception {
        var calculator = new LongestCollatzSequenceCalculator();
        long result = calculator.getLongestCollatzSequence();

        System.out.println(result);
    }
}
