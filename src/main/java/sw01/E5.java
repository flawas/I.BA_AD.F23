package sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The E5 class implements the Ackermann function and provides methods to manipulate a counter.
 * It calculates the Ackermann function using recursion and keeps track of the number of function calls made using a counter.
 */
public class E5 {

    /**
     * Logger for logging information and results.
     */
    private static final Logger Log = LogManager.getLogger();

    /**
     * Counter to keep track of the number of Ackermann function calls.
     */
    private int counter;

    /**
     * Retrieves the current value of the counter.
     *
     * @return The current value of the counter.
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Increments the counter by one.
     */
    public void plusCounter() {
        this.counter++;
    }

    /**
     * Resets the counter to zero.
     */
    public void resetCounter() {
        this.counter = 0;
    }

    /**
     * Default constructor for the E5 class.
     */
    public E5() {
    }

    /**
     * Recursive method to calculate the Ackermann function for given values of n and m.
     *
     * @param n The first parameter of the Ackermann function.
     * @param m The second parameter of the Ackermann function.
     * @return The result of the Ackermann function for the given values of n and m.
     */
    public int ack(int n, int m) {
        plusCounter();
        if (n == 0) {
            return m + 1;
        } else if (m == 0) {
            return ack(n - 1, 1);
        } else {
            return ack(n - 1, ack(n, m - 1));
        }
    }

    /**
     * Main method for testing the Ackermann function and tracking the number of function calls.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        Log.info("Aufgabe a");
        Log.info("Die Ackermann Funktion ist in der Rekursion geschachtelt.");

        E5 e5 = new E5();
        Log.info("Aufgabe b");
        Log.info("n: 0, m: 4 " + e5.ack(0, 4));
        Log.info("n: 1, m: 2 " + e5.ack(1, 2));
        Log.info("n: 2, m: 2 " + e5.ack(2, 2));

        e5.resetCounter();
        e5.ack(2, 2);
        Log.info("Aufgabe c");
        Log.info("Ackermann wurde " + e5.getCounter() + " mal aufgerufen.");
    }
}