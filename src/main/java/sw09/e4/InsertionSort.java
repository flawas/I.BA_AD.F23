package sw09.e4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionSort {

    private int [] array;
    private static final Logger Log = LogManager.getLogger();

    public InsertionSort(final int [] array) {
        this.array = array;
    }

    public void insertionSort() {
        int elt;
        int j;
        for(int i = 1; i < array.length; i++) {
            elt = array[i];
            j = i;
            while((j > 0) && array[j-1] > elt) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = elt;
        }
    }

    public void insertionSort2() {
        int elt;
        int j;
        for (int i = 2; i < array.length; i++) {
            elt = array[i];
            array[0] = elt;
            j = i;
            while (array[j-1] > elt) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = elt;
        }
    }

    public void insertionSort2Modified() {
        int elt;
        int j;
        int dummy = array[0];
        for (int i = 2; i < array.length; i++) {
            elt = array[i];
            array[0] = elt;
            j = i;
            while (array[j-1] > elt) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = elt;
        }
        int z = 1;
        while(dummy > array[z]){
            array[z - 1] = array[z];
            z++;
        }
        array[z -1] = dummy;
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

        InsertionSort insertionSort = new InsertionSort(new int[]{ 5,6,1,3,4,2,9,8,7 });
        long startTime1 = System.nanoTime();
        insertionSort.insertionSort();
        long endtime1 = System.nanoTime();
        System.out.println(insertionSort.printArray());

        Log.info("Time spent: " + (endtime1 - startTime1));


        InsertionSort insertionSort2 = new InsertionSort(new int[]{ 5,6,1,3,4,2,9,8,7 });
        long startTime2 = System.nanoTime();
        insertionSort2.insertionSort2Modified();
        long endTime2 = System.nanoTime();
        System.out.println(insertionSort2.printArray());
        Log.info("Time spent: " + (endTime2 - startTime2));

    }


}
