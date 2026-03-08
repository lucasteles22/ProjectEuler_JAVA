import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class LongestCollatzSequenceCalculator {

    public long getLongestCollatzSequence() {
        long start = 1;
        long max =  1_000_000;

        var threads = new ArrayList<Thread>();
        var sequences = Collections.synchronizedMap(new HashMap<Long, List<Long>>());

        for (long i = start; i <= max; i++) {
            final long number = i;
            var thread = Thread.ofVirtual().start(() -> {
                List<Long> sequence = getCollatzSequence(number);
                sequences.put(number, sequence);
            });
            threads.add(thread);
        }
        joinThreads(threads);

        Entry<Long, List<Long>> response = sequences.entrySet()
            .stream()
            .max(Comparator.comparing(entry -> entry.getValue().size()))
            .orElseThrow(() -> new RuntimeException("Unknonw error"));

        return response.getKey();
    }

    private void joinThreads(ArrayList<Thread> threads) {
        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Long> getCollatzSequence(long n) {
        var sequence = new ArrayList<Long>();
        while (n > 1) {
            sequence.add(n);
            if (n % 2 == 0) {
                n = even(n);
            } else {
                n = odd(n);
            }
        }
        sequence.add(1L);
        return sequence;
    }

    private long even(long n) {
        return n / 2;
    }

    private long odd(long n) {
        return 3 * n + 1;
    }
}
