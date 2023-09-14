package sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The E7 class provides methods to work with symmetric numbers.
 * It calculates the count of symmetric numbers within a certain range, checks if a number is symmetric,
 * finds the next symmetric number after a given number, and determines the maximum and minimum symmetric numbers
 * for a specified number of places.
 */
public class E7 {

    /**
     * Logger for logging information and results.
     */
    private static final Logger Log = LogManager.getLogger();

    /**
     * Default constructor for the E7 class.
     */
    public E7() {
    }

    /**
     * Calculates the count of symmetric numbers within a specified range of places.
     *
     * @param places The number of places to consider for symmetric numbers.
     * @return The count of symmetric numbers within the specified range of places.
     */
    public int getSymmetricCount(int places) {
        int maxNumber = getMaxNumber(places);
        int minNumber = getMinNumber(places);
        int counter = 0;

        while (minNumber <= maxNumber) {
            if (checkSymmetric(minNumber)) {
                counter++;
            }

            minNumber++;
        }
        return counter;
    }

    /**
     * Checks if a given number is symmetric.
     *
     * @param number The number to check for symmetry.
     * @return True if the number is symmetric, false otherwise.
     */
    public boolean checkSymmetric(final int number) {
        String s = Integer.toString(number);
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i) + temp;
        }
        return s.equals(temp);
    }

    /**
     * Finds the next symmetric number after a given number.
     *
     * @param number The number to start the search for the next symmetric number.
     * @return The next symmetric number after the given number.
     */
    public int getNextSymmetric(int number) {
        while (!checkSymmetric(number)) {
            number++;
        }
        return number;
    }

    /**
     * Determines the maximum symmetric number for a specified number of places.
     *
     * @param places The number of places to consider for the maximum symmetric number.
     * @return The maximum symmetric number for the specified number of places.
     */
    public int getMaxNumber(final int places) {
        String temp = "";
        for (int i = 0; i < places; i++) {
            temp = 9 + temp;
        }
        return Integer.parseInt(temp);
    }

    /**
     * Determines the minimum symmetric number for a specified number of places.
     *
     * @param places The number of places to consider for the minimum symmetric number.
     * @return The minimum symmetric number for the specified number of places.
     */
    public int getMinNumber(final int places) {
        if (places == 1) return 0;
        String temp = "1";
        for (int i = 1; i < places; i++) {
            temp += 0;
        }
        return Integer.parseInt(temp);
    }

    /**
     * Main method for testing the symmetric number methods and logging the results.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        Log.info("Aufgabe a");
        Log.info("Beispielsweise: 121");

        E7 e7 = new E7();
        Log.info("Aufgabe b");
        e7.getSymmetricCount(2);
        Log.info("1-stellige symmetrische Zahlen: " + e7.getSymmetricCount(1));
        Log.info("2-stellige symmetrische Zahlen: " + e7.getSymmetricCount(2));
        Log.info("3-stellige symmetrische Zahlen: " + e7.getSymmetricCount(3));
        Log.info("4-stellige symmetrische Zahlen: " + e7.getSymmetricCount(4));

        Log.info("Aufgabe c");
        Log.info("n-stellen symmetrische Zahl: (bswp. 7 Stellen) " + e7.getSymmetricCount(7));

        Log.info("Aufgabe d");
        Log.info("Teste Symmetrie 7: " + e7.checkSymmetric(7));
        Log.info("Teste Symmetrie 8227228: " + e7.checkSymmetric(8227228));

        Log.info("Aufgabe e");
        Log.info("nächstgrössere symmetrische Zahl bestimmen 3: " + e7.getNextSymmetric(3));
        Log.info("nächstgrössere symmetrische Zahl bestimmen 193: " + e7.getNextSymmetric(193));
    }

}
