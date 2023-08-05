package sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class E5 {

    private static final Logger Log = LogManager.getLogger();
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void plusCounter() {
        this.counter++;
    }

    public void resetCounter() {
        this.counter = 0;
    }

    public E5() {
    }

    public int ack(int n, int m) {
        plusCounter();
        if(n == 0) {
            return m + 1;
        } else if (m == 0) {
            return ack(n -1, 1);
        } else {
            return ack(n-1, ack(n, m - 1));
        }
    }

    public static void main(String[] args) {
        Log.info("Aufgabe a");
        Log.info("Die Ackermann Funktion ist in der Rekursion geschachtelt.");

        E5 e5 = new E5();
        Log.info("Aufgabe b");
        Log.info("n: 0, m: 4 " + e5.ack(0,4));
        Log.info("n: 1, m: 2 " + e5.ack(1,2));
        Log.info("n: 2, m: 2 " + e5.ack(2,2));

        e5.resetCounter();
        e5.ack(2,2);
        Log.info("Aufgabe c");
        Log.info("Ackermann wurde " + e5.getCounter() + " mal aufgerufen.");
    }

}
