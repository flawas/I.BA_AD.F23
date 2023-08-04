package sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class E2 {
    static int counter1;
    static int counter2;
    static int counter3;
    private static final Logger Log = LogManager.getLogger();

    private static void task1() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Log.error(ex.toString());
        }
        counter1++;
    }

    private static void task2() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException ex) {
            Log.error(ex.toString());
        }
        counter2++;
    }

    private static void task3() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Log.error(ex.toString());
        }
        counter3++;
    }

    private static void task(final int n) {
        task1(); task1(); task1(); task1(); // T ~ 4
        for (int i = 0; i < n; i++) { // äussere Schleife: n-mal
            task2(); task2(); task2(); // T ~ n · 3
            for (int j = 0; j < n; j++) { // innerer Schleife: n-mal
                task3(); task3(); // T ~ n · n· 2
            }
        }
    }

    private static void reset() {
        counter1 = 0;
        counter2 = 0;
        counter3 = 0;
    }

    public static void main(String[] args) {
        long starttime1 = System.currentTimeMillis();
        task(5);
        Log.info("Task1 " + counter1 + ", Task2 " + counter2 + ", Task3 " + counter3);
        long stoptime1 = System.currentTimeMillis();
        reset();
        Log.info("Laufzeit " + (stoptime1 - starttime1) + " Milisekunden");

        long starttime2 = System.currentTimeMillis();
        task(10);
        Log.info("Task1 " + counter1 + ", Task2 " + counter2 + ", Task3 " + counter3);
        long stoptime2 = System.currentTimeMillis();
        reset();
        Log.info("Laufzeit " + (stoptime2 - starttime2) + " Milisekunden");

        long starttime3 = System.currentTimeMillis();
        task(20);
        Log.info("Task1 " + counter1 + ", Task2 " + counter2 + ", Task3 " + counter3);
        long stoptime3 = System.currentTimeMillis();
        Log.info("Laufzeit " + (stoptime3 - starttime3) + " Milisekunden");
    }
}
