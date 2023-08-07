package sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * The E4 class provides different methods to calculate the Fibonacci sequence.
 * It includes recursive approaches and an iterative approach, along with a memoization technique using a HashMap to optimize performance.
 */
public class E4 {

    /**
     * Logger for logging information and results.
     */
    private static final Logger Log = LogManager.getLogger();

    /**
     * HashMap to store previously computed Fibonacci numbers for memoization.
     */
    Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

    /**
     * Constructs an E4 object and initializes the HashMap with base Fibonacci numbers (0 and 1).
     */
    public E4() {
        hashMap.put(0, 0);
        hashMap.put(1, 1);
    }

    /**
     * Recursive method to calculate the Fibonacci number at a given position using the basic recursive approach.
     *
     * @param input The position of the Fibonacci number to be calculated.
     * @return The Fibonacci number at the given position.
     */
    public int fiboRec1(final int input) {
        // Base cases
        if (input == 0) {
            return 0;
        } else if (input == 1) {
            return 1;
        } else {
            // Recursive formula
            return fiboRec1(input - 2) + fiboRec1(input - 1);
        }
    }

    /**
     * Recursive method to calculate the Fibonacci number at a given position using memoization with a HashMap.
     * It retrieves already calculated Fibonacci numbers from the HashMap to avoid redundant calculations.
     *
     * @param input The position of the Fibonacci number to be calculated.
     * @return The Fibonacci number at the given position.
     */
    public int fiboRec2(final int input) {
        // Base cases or retrieve from HashMap if already calculated
        if (hashMap.containsKey(input)) {
            return hashMap.get(input);
        } else {
            // Recursive formula
            int calc = fiboRec2(input - 2) + fiboRec2(input - 1);
            hashMap.put(input, calc);
            return calc;
        }
    }

    /**
     * Iterative method to calculate the Fibonacci number at a given position using a loop.
     *
     * @param input The position of the Fibonacci number to be calculated.
     * @return The Fibonacci number at the given position.
     */
    public int fiboIter(final int input) {
        if (input == 0) {
            return 0;
        } else if (input == 1) {
            return 1;
        } else {
            int value1 = 0;
            int value2 = 1;
            for (int i = 1; i <= input; i++) {
                int oldvalue2 = value2;
                value2 = value1 + value2;
                value1 = oldvalue2;
            }
            return value1;
        }
    }

    /**
     * Prints the contents of the HashMap used for memoization.
     * (Debugging method)
     */
    public void printHashMap() {
        Log.debug(hashMap.toString());
    }

    /**
     * Main method for testing the different Fibonacci calculation methods and logging their execution times.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        E4 e4 = new E4();

        long startTimeFiboRec1 = System.currentTimeMillis();
        Log.info(e4.fiboRec1(14));
        long endTimeFiboRec1 = System.currentTimeMillis();
        Log.info("Rechenzeit FiboRec1: " + (endTimeFiboRec1 - startTimeFiboRec1) + " Millisekunden.");

        long startTimeFiboRec2Saved = System.currentTimeMillis();
        Log.info(e4.fiboRec2(1));
        long endTimeFiboRec2Saved = System.currentTimeMillis();
        Log.info("Rechenzeit FiboRec2 saved result: " + (endTimeFiboRec2Saved - startTimeFiboRec2Saved) + " Millisekunden.");

        long startTimeFiboRec2WithSave = System.currentTimeMillis();
        Log.info(e4.fiboRec2(14));
        long endTimeFiboRec2WithSave = System.currentTimeMillis();
        Log.info("Rechenzeit FiboRec2 with save: " + (endTimeFiboRec2WithSave - startTimeFiboRec2WithSave) + " Millisekunden.");

        long startTimeFiboIter = System.currentTimeMillis();
        Log.info(e4.fiboIter(14));
        long endTimeFiboIter = System.currentTimeMillis();
        Log.info("Rechenzeit FiboIter: " + (endTimeFiboIter - startTimeFiboIter) + " Millisekunden.");
    }

}

