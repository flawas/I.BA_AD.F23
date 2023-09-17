package sw10.e2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Quicksort {

    private static char[] a;
    private static int ANZAHL_BUCHSTABEN = 100000;
    private static final Logger Log = LogManager.getLogger();


    public Quicksort() {
        this.a = new char[ANZAHL_BUCHSTABEN];
        String alphabet = "abcdefghiklmnopqrstuvwxyz";
        for (int i = 0; i < ANZAHL_BUCHSTABEN; i++) {
            a[i] = alphabet.charAt(new Random().nextInt(alphabet.length()));
        }
        Log.debug(printArray());
    }

    private static void exchange(final char[] a, final int firstIndex, final int secondIndex) {
        char tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    public void quickSort(final char[] a) {
        this.a = a;
        this.quickSort(a, 0, a.length -1);
    }

    public static final void quickSort(final char[] a, final int left, final int right) {
        int up = left;
        int down = right - 1;
        char t = a[right];
        boolean allChecked = false;
        do {
            while (a[up] < t) { up++;
            }
            while ((a[down] >= t) && (down > up)) {
                down--;
            }
            if (down > up) {
                exchange(a, up, down);
                up++; down--; } else {
                allChecked = true;
            }
        } while (!allChecked);
        exchange(a, up, right);
        if (left < (up - 1)) {
            quickSort(a, left, (up - 1));
        }
        if ((up + 1) < right) {
            quickSort(a, (up + 1), right);
        }
    }

    public String printArray() {
        String returnString = "";
        if(a.length > 1) {
            returnString = returnString + a[0];
        }
        for(int i = 1; i < a.length; i++) {
            returnString = returnString + " " + a[i];
        }
        return returnString;
    }

    public static void main(String[] args) {
        Quicksort quicksort = new Quicksort();
        long startTime1 = System.currentTimeMillis();
        quicksort.quickSort(a.clone());
        long endTime1 = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        quicksort.quickSort(a.clone());
        long endTime2 = System.currentTimeMillis();

        long startTime3 = System.currentTimeMillis();
        quicksort.quickSort(a.clone());
        long endTime3 = System.currentTimeMillis();
        //Log.info(quicksort.printArray());
        Log.info("Zeit in Sekunden");
        Log.info("Laufzeit 1: " + (endTime1 - startTime1));
        Log.info("Laufzeit 2: " + (endTime2 - startTime2));
        Log.info("Laufzeit 3: " + (endTime3 - startTime3));
    }

}
