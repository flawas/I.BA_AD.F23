package sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class E1 {

    static int counterA;
    static int counterB;
    private static final Logger Log = LogManager.getLogger();

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

    public static void reset() {
        counterA = 0;
        counterB = 0;
    }

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
