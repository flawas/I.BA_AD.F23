package sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class E7 {

    private static final Logger Log = LogManager.getLogger();

    public E7() {
    }

    public int getSymmetricCount(int places) {
        int maxNumber = getMaxNumber(places);
        int minNumber = getMinNumber(places);
        int counter = 0;

        while(minNumber <= maxNumber) {
            if(checkSymmetric(minNumber)) {
                counter++;
            }

            minNumber++;
        }
        return counter;
    }

    public boolean checkSymmetric(final int number) {
        String s = Integer.toString(number);
        String temp = "";
        for(int i = 0; i < s.length(); i++) {
            temp = s.charAt(i) + temp;
        }
        if (s.equals(temp)) {
            return true;
        } else {
            return false;
        }
    }

    public int getNextSymmetric(int number) {
        while(!checkSymmetric(number)){
            number++;
        }
        return number;
    }

    public int getMaxNumber(final int places) {
        String temp = "";
        for(int i = 0; i < places; i++) {
            temp = 9 + temp;
        }
        return Integer.parseInt(temp);
    }

    public int getMinNumber(final int places) {
        if(places == 1) return 0;
        String temp = "1";
        for(int i = 1; i < places; i++) {
            temp  += 0;
        }
        return Integer.parseInt(temp);
    }

    public static void main(String[] args) {
        Log.info("Aufgabe a");
        Log.info("Beispielsweise: 121");

        E7 e7 = new E7();
        Log.info("Aufgabe b");
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
