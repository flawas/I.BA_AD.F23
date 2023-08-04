package sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class E4 {

    private static final Logger Log = LogManager.getLogger();

    Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

    public E4() {
        hashMap.put(0,0);
        hashMap.put(1,1);
    }

    public int fiboRec1(final int input) {
        // Rekursionsbasis
        if(input == 0) {
            return 0;
        } else if(input == 1) {
            return 1;
        } else {
            // Rekursionsvorschrift
            return fiboRec1(input - 2) + fiboRec1(input - 1);
        }
    }

    public int fiboRec2(final int input) {
        // Rekursionsbais
        if(hashMap.containsKey(input)) {
            //Log.debug("Get from hashMap: " + input + "/" + hashMap.get(input));
            return hashMap.get(input);
        } else {
            // Rekursionsvorschrift
            int calc = fiboRec2(input - 2) + fiboRec2(input - 1);
            hashMap.put(input, calc);
            //Log.debug("Save to hashMap: " + input + "/" + hashMap.get(input));
            return calc;
        }
    }

    public int fiboIter(final int input) {
        if (input == 0) {
            return 0;
        } else if (input == 1) {
            return 1;
        } else {
            int value1 = 0;
            int value2 = 1;
            for(int i = 1; i <= input; i++) {
                int oldvalue2 = value2;
                value2 = value1 + value2;
                value1 = oldvalue2;
            }
            return value1;
        }
    }

    public void printHashMap() {
        Log.debug(hashMap.toString());
    }

    public static void main(String[] args) {
        E4 e4 = new E4();

        long startTimeFiboRec1 = System.currentTimeMillis();
        Log.info(e4.fiboRec1(14));
        long endtimeFiboRec1 = System.currentTimeMillis();
        Log.info("Rechenzeit FiboRec1: " + (endtimeFiboRec1 - startTimeFiboRec1) + " Milisekunden.");

        long startTimeFiboRec2Saved = System.currentTimeMillis();
        Log.info(e4.fiboRec2(1));
        long endTimeFiboRec2Saved = System.currentTimeMillis();
        Log.info("Rechenzeit FiboRec2 saved result: " + (endTimeFiboRec2Saved - startTimeFiboRec2Saved) + " Milisekunden.");

        long startTimeFiboRec2WithSave = System.currentTimeMillis();
        Log.info(e4.fiboRec2(14));
        long endTimeFiboRec2WithSave = System.currentTimeMillis();
        Log.info("Rechenzeit FiboRec2 with save: " + (endTimeFiboRec2WithSave - startTimeFiboRec2WithSave) + " Milisekunden.");

        long startTimeFiboIter = System.currentTimeMillis();
        Log.info(e4.fiboIter(14));
        long endTimeFiboIter = System.currentTimeMillis();
        Log.info("Rechenzeit FiboIter: " + (endTimeFiboIter - startTimeFiboIter) + " Milisekunden.");
        //e4.printHashMap();
    }

}
