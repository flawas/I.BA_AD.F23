package sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The E1 class provides methods for calculating the greatest common divisor (GCD) of two integers.
 * It offers three different algorithms: iterative1, iterative2, and recursive.
 */
public class E1 {

    /**
     * Counter for the number of subtractions performed by the ggtIterativ1 method.
     */
    static int counterA;

    /**
     * Counter for the number of modulo operations performed by the ggtIterarativ2 and ggtRekursiv methods.
     */
    static int counterB;

    /**
     * Logger for logging information and results.
     */
    private static final Logger Log = LogManager.getLogger();

    /**
     * Calculates the greatest common divisor (GCD) of two integers using the iterative1 algorithm.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The GCD of the two input integers.
     */
    public static int ggtIterativ1(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
                counterA++;
            } else {
                b = b - a;
                counterB++;
            }
        }
        return a;
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers using the iterative2 algorithm.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The GCD of the two input integers.
     */
    public static int ggtIterarativ2(int a, int b) {
        while ((a != 0) && (b != 0)) {
            if (a > b) {
                a = a % b;
                counterA++;
            } else {
                b = b % a;
                counterB++;
            }
        }
        return  (a + b);
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers using the recursive algorithm.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The GCD of the two input integers.
     */
    public static int ggtRekursiv(final int a, final int b) {
        if (a > b) {
            counterA++;
            return ggtRekursiv(a - b, b);
        } else {
            if (a < b) {
                counterA++;
                return ggtRekursiv(a, b - a);
            } else {
                counterB++;
                return b;
            }
        }
    }

    /**
     * Resets the counters to zero, allowing for a fresh calculation of GCDs.
     */
    public static void reset() {
        counterA = 0;
        counterB = 0;
    }

    /**
     * Main method for testing the GCD calculation algorithms.
     * It calculates the GCD of two integers using all three algorithms and logs the results and counters.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        Log.info(ggtIterativ1(16, 68));
        Log.info("CounterA: " + counterA + " CounterB: " + counterB);
        reset();

        Log.info(ggtIterarativ2(16, 68));
        Log.info("CounterA: " + counterA + " CounterB: " + counterB);
        reset();

        Log.info(ggtRekursiv(16, 68));
        Log.info("CounterA: " + counterA + " CounterB: " + counterB);
    }
}
