package sw08.e5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;


public class BubbleSort {

    private int [] array;
    private static final Logger Log = LogManager.getLogger();

    public BubbleSort(final int [] array) {
        this.array = array;
    }

    public void selectionSort(){
        int zeiger = array.length - 1;

        for(int i = 0; i < array.length; i++) {
            int biggest = 0;
            int biggestPos = 0;
            for(int j = 0; j <= zeiger; j++) {
                if(array[j] > biggest) {
                    biggest = array[j];
                    biggestPos = j;
                }
            }
            int tempElement = array[zeiger];
            array[zeiger] = biggest;
            array[biggestPos] = tempElement;
            zeiger--;
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
        BubbleSort bubbleSort = new BubbleSort( new int[]{ 5,6,1,3,4,2,9,8,7 });
        bubbleSort.selectionSort();
        Log.info(bubbleSort.printArray());

    }


}
