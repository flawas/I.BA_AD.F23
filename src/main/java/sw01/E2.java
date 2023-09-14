package sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The E2 class performs three different tasks (task1, task2, and task3) with varying time complexities and logs the number of times each task is executed.
 * It also measures the runtime of each task with different input values and logs the execution times in milliseconds.
 */
public class E2 {
    /**
     * Counter for the number of times task1 is executed.
     */
    static int counter1;

    /**
     * Counter for the number of times task2 is executed.
     */
    static int counter2;

    /**
     * Counter for the number of times task3 is executed.
     */
    static int counter3;

    /**
     * Logger for logging information and results.
     */
    private static final Logger Log = LogManager.getLogger();

    /**
     * Performs task1, which involves a short sleep time and increments the corresponding counter.
     */
    private static void task1() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Log.error(ex.toString());
        }
        counter1++;
    }

    /**
     * Performs task2, which involves a moderate sleep time and increments the corresponding counter.
     */
    private static void task2() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Log.error(ex.toString());
        }
        counter2++;
    }

    /**
     * Performs task3, which involves a longer sleep time and increments the corresponding counter.
     */
    private static void task3() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Log.error(ex.toString());
        }
        counter3++;
    }

    /**
     * Performs a set of tasks with nested loops, each task running a specific number of times based on the input value n.
     * The method logs the number of times each task is executed.
     *
     * @param n The input value that determines the number of times each task is executed in the nested loops.
     */
    private static void task(final int n) {
        task1(); task1(); task1(); task1(); // T ~ 4
        for (int i = 0; i < n; i++) { // Outer loop: runs n times
            task2(); task2(); task2(); // T ~ n · 3
            for (int j = 0; j < n; j++) { // Inner loop: runs n times
                task3(); task3(); // T ~ n · n· 2
            }
        }
    }

    /**
     * Resets the counters to zero, allowing for a fresh measurement of task execution.
     */
    private static void reset() {
        counter1 = 0;
        counter2 = 0;
        counter3 = 0;
    }

    /**
     * Main method for testing the task execution with different input values and measuring their runtimes.
     * It performs tasks with input values 5, 10, and 20, and logs the results and execution times in milliseconds.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        ArrayList<Integer> resultStore = new ArrayList<>();

        for(int i = 0; i < 50; i++) {
            Log.debug("n = " + i);
            long starttime1 = System.currentTimeMillis();
            task(i);
            long stoptime1 = System.currentTimeMillis();
            Log.info("Laufzeit " + (stoptime1 - starttime1) + " Millisekunden");
            Integer result = counter1 + counter2 + counter3;
            resultStore.add(result);
            reset();
        }
        Log.debug("Laufzeiten");
        for(int i = 0; i < resultStore.size(); i++){
            Log.info(i + ": " + resultStore.get(i));
        }

    }
}
