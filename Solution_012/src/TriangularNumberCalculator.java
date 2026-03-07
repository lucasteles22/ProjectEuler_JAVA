import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class TriangularNumberCalculator {

    public long getAnswer() {
        long divisorsCount = 0;
        long triangleNumber = 0;
        long number = 1;
        do {
            triangleNumber = getTriangleFormula(number);
            Map<Long, Integer> factors = toFactor(triangleNumber);
            divisorsCount = getDivisorsCount(factors);
            number++;
        } while (divisorsCount <= 500);

        return triangleNumber;
    }

    private long getTriangleFormula(long val) {
        return (val * (val + 1)) / 2;
    }

    private Map<Long, Integer> toFactor(long number) {
        Map<Long, Integer> factors = new HashMap<>();

        for (long i = 2; i * i <= number; i++) {
            while (number % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                number /= i;
            }
        }

        if (number > 1) {
            factors.put(number, 1);
        }

        return factors;
    }

    private long getDivisorsCount(Map<Long, Integer> factors) {
        AtomicLong response = new AtomicLong(0);

        factors.forEach((number, elv) -> {
            if (response.get() == 0)  {
                response.set(elv + 1);
            } else {
                response.set(response.get() * (elv + 1));
            }
        });

        return response.get();
    }
}
