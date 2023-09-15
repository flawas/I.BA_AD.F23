package sw08.e6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShellSort {

    private int [] array;
    private static final Logger Log = LogManager.getLogger();

    public ShellSort(final int [] array) {
        this.array = array;
    }

    public void shellsort() {

        int schrittweite = 4;

        while(schrittweite > 0) {
            int zeiger = 0;
            while(zeiger < array.length - 1) {
                if(((zeiger + schrittweite) < array.length) && array[zeiger] > array[zeiger + schrittweite]) {
                    int tempElement = array[zeiger];
                    array[zeiger] = array[zeiger + schrittweite];
                    array[zeiger + schrittweite] = tempElement;
                }
                zeiger++;
            }
            schrittweite = schrittweite / 2;
        }
    }

    public String printArray() {
        String returnString = "";
        if(array.length > 1) {
            returnString = returnString + array[0];
        }
        for(int i = 1; i < array.length; i++) {
            returnString = returnString + " " + array[i];
        }
        return returnString;
    }

    public static void main(String[] args) {
        ShellSort shellsort = new ShellSort(new int[]{ 5,6,1,3,4,2,9,8,7 });
        shellsort.shellsort();
        Log.info(shellsort.printArray());
    }
}
