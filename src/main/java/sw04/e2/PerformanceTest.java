package sw04.e2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * A class for performing performance tests on different data structures.
 */
public class PerformanceTest {

    /**
     * The capacity for the data structures in the performance tests.
     */
    final static int capacity = 100000;

    /**
     * The number of performance tests to run.
     */
    final static int performanceTests = 50;

    /**
     * Logger for logging debug information.
     */
    private static final Logger Log = LogManager.getLogger();

    /**
     * Map to store performance results for different data structures.
     */
    private final Map<String, Long> performance = new HashMap<>();

    /**
     * Constructs a new PerformanceTest and performs the performance tests.
     */
    public PerformanceTest() {
        performArrayTests();
        performStackTests();
        performQueueTests();
    }

    private void performArrayTests() {
        for (int i = 0; i < performanceTests; i++) {
            long startTime = System.currentTimeMillis();
            new AppArray(capacity);
            long endTime = System.currentTimeMillis();
            performance.put("Array" + i, (endTime - startTime));
        }
        Log.info("Array Zeiten:" + getPerformances("Array") + " Milisekunden");
        Log.info("Array Average: " + getAveragePerformances("Array") + " Milisekunden");
    }

    private void performStackTests() {
        for (int i = 0; i < performanceTests; i++) {
            long startTime = System.currentTimeMillis();
            new AppStack(capacity);
            long endTime = System.currentTimeMillis();
            performance.put("Stack" + i, (endTime - startTime));
        }
        Log.info("Stack Zeiten:" + getPerformances("Stack") + " Milisekunden");
        Log.info("Stack Average: " + getAveragePerformances("Stack") + " Milisekunden");
    }

    private void performQueueTests() {
        for (int i = 0; i < performanceTests; i++) {
            long startTime = System.currentTimeMillis();
            new AppDeque(capacity);
            long endTime = System.currentTimeMillis();
            performance.put("Queue" + i, (endTime - startTime));
        }
        Log.info("Queue Zeiten:" + getPerformances("Queue") + " Milisekunden");
        Log.info("Queue Average: " + getAveragePerformances("Queue") + " Milisekunden");
    }

    private String getPerformances(final String type) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < performanceTests; i++) {
            returnString.append(", ").append(performance.get(type + i));
        }
        return returnString.toString();
    }

    private double getAveragePerformances(final String type) {
        long sum = 0;
        for (int i = 0; i < performanceTests; i++) {
            sum += performance.get(type + i);
        }
        return (double) sum / performanceTests;
    }

    /**
     * Main method to run the performance tests.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        new PerformanceTest();
    }
}