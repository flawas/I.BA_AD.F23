package sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * The E3 class contains various mathematical functions and algorithms to calculate and analyze the time complexities of different operations.
 * It includes functions for logarithms, powers, and factorials, as well as methods to compare and estimate time complexities.
 */
public class E3 {

    /**
     * Logger for logging information and results.
     */
    private static final Logger Log = LogManager.getLogger();

    /**
     * Calculates the logarithm base 10 of a given number.
     *
     * @param n The number for which the logarithm is calculated.
     * @return The logarithm base 10 of the input number.
     */
    private static double log(double n) {
        return roundAvoid(Math.log10(n), 2);
    }

    /**
     * Calculates the logarithm base 2 of a given number.
     *
     * @param n The number for which the logarithm is calculated.
     * @return The logarithm base 2 of the input number.
     */
    private static double ld(double n) {
        return roundAvoid(Math.log(n) / Math.log(2), 2);
    }

    /**
     * Calculates the natural logarithm of a given number.
     *
     * @param n The number for which the natural logarithm is calculated.
     * @return The natural logarithm of the input number.
     */
    private static double ln(double n) {
        return roundAvoid(Math.log(n), 2);
    }

    /**
     * Calculates the value of n * log(n).
     *
     * @param n The number for which the value of n * log(n) is calculated.
     * @return The value of n * log(n).
     */
    private static double nlogn(double n) {
        return roundAvoid(n * Math.log10(n), 2);
    }

    /**
     * Calculates the power of a number to a given exponent.
     *
     * @param n       The base number.
     * @param anzahl  The exponent value.
     * @return The result of n raised to the power of the given exponent.
     */
    private static double hoch(double n, int anzahl) {
        for (int i = 1; i < anzahl; i++) {
            n = n * n;
        }
        return n;
    }

    /**
     * Rounds a double value to a specified number of decimal places.
     *
     * @param value  The double value to be rounded.
     * @param places The number of decimal places to round to.
     * @return The rounded double value.
     */
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    /**
     * Calculates the factorial of a given number.
     *
     * @param n The number for which the factorial is calculated.
     * @return The factorial of the input number.
     */
    private static double fakultaet(double n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fakultaet(n - 1);
        }
    }

    /**
     * Estimates the runtime of an algorithm based on the old time, old input, new input, and the algorithm's time complexity.
     *
     * @param oldTime    The old runtime of the algorithm with the old input.
     * @param oldInput   The old input value for the algorithm.
     * @param newInput   The new input value for which the runtime is estimated.
     * @param algorithm  The time complexity of the algorithm (e.g., "O(1)", "O(n)", "O(n^2)", "O(n*log(n)")).
     * @return The estimated runtime of the algorithm with the new input value.
     */
    private static double rechenzeit(double oldTime, double oldInput, double newInput, String algorithm) {
        switch (algorithm) {
            case "O(1)":
                return oldTime;
            case "O(n)":
                return (oldTime / oldInput * newInput);
            case "O(n^2)":
                return (oldTime / hoch(oldInput, 2) * hoch(newInput, 2));
            case "O(n*log(n))":
                return (oldTime / (oldInput * log(oldInput)) * (newInput * log(newInput)));
        }
        return -1;
    }

    /**
     * Main method for testing various mathematical functions and algorithms.
     * It logs the results for different operations and compares their time complexities.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        Log.info("Aufgabe a");
        Log.info("log n, ld n, n, n * log n, n^2, n^3, 2^n, 3^n, n!");
        int[] numbers = {1,2,5,10,20,50,100};
        for (int i : numbers) {
            Log.info(log(i)+ ", " + ld(i) + ", " + i + ", " + nlogn(i) + ", " + hoch(i, 2) + ", " +
                    hoch(i, 3) + ", " + hoch(2, i) + ", " + hoch(3, i) + ", " + fakultaet(i));
        }

        Log.info("------");
        Log.info("Aufgabe b");
        Log.info("Diese Aufgabe wurde mit n = 5 gelöst");
        int n = 5;
        Log.info("1: n^3 + 0.1 * 2^n = " + (hoch(n,3) + 0.1 * hoch(2,5)) + " --> O(2^n)");
        Log.info("2: 5326 + ln(n) = " + (5326 + ln(n)) + " --> O(ln(n)");
        Log.info("3: 2 + 37 * n^3 + 0.01 * n^4 = " + (2 + 37 * hoch(n,3) + 0.01 * hoch(n,4)) + " --> O(n^4)");
        Log.info("4: 1000 * n + n^3 = " + (1000 * n + hoch(n,3)) + " --> O(n^3)");
        Log.info("5: n^7 + n! = " + (hoch(n, 7) + fakultaet(n)) + " --> O(n!)");
        Log.info("6: ln(n) + 1000 * n = " + (ln(n) + 1000 * n) + " --> O(n)");

        Log.info("------");
        Log.info("Aufgabe c");
        Log.info("Ordnen Sie die resultierenden Ordnungen von b) gemäss ihrer Wachstumsrate, d.h. zuerst die \n" +
                "kleinste, dann aufsteigend die grösseren.");
        Log.info("2, 6, 1, 4, 3, 5");

        Log.info("------");
        Log.info("Aufgabe d, alle Angaben in Sekunden");
        Log.info("Rechenzeit O(1): " + rechenzeit(0.1, 10000, 100000, "O(1)"));
        Log.info("Rechenzeit O(n^2): " + rechenzeit(0.1, 10000, 100000, "O(n^2)"));
        Log.info("Rechenzeit O(n * log(n): " + rechenzeit(0.1, 10000, 100000, "O(n*log(n))"));
    }
}
