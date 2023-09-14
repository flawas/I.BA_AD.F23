package algorithmen.sortierung;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class InsertionSort {

    private static final Logger Log = LogManager.getLogger();
    private static int AVERAGE_CALCULATIONS = 3;

    public static void insertionSort(final int[] array) {
        int elt;
        int j;
        for (int i = 1; i < array.length; i++) {
            elt = array[i];
            j = i;
            while((j > 0) && (array[j-1] > elt)) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = elt;
        }
    }

    public static void printArray(final int[] array) {
        for(int i = 0; i < array.length; i++) {
            Log.info(i + ": " + array[i]);
        }
    }

    public static void main(String[] args) {
        int [] dataUnsorted = {5,33,12,13,8,1,41,12};
        int [] dataSorted = {1,5,8,12,12,13,33,41};
        int [] dataReverseSorted = {41,33,13,12,12,8,5,1};

        Log.info("n = " + dataSorted.length);
        Log.info("n*n = " + dataSorted.length * dataSorted.length);

        Map<String, Long> cache = new HashMap<>();
        for(int i = 0; i < AVERAGE_CALCULATIONS; i++) {
            Future<Long> future = new AverageTime().averageTimeInsertionSort(dataUnsorted);
            try {
                cache.put("DataUnsorted", future.get());
            } catch (InterruptedException e) {
                Log.error(e.getMessage());
            } catch (ExecutionException e) {
                Log.error(e.getMessage());
            }
        }

        for(int i = 0; i < AVERAGE_CALCULATIONS; i++) {
            Future<Long> future = new AverageTime().averageTimeInsertionSort(dataSorted);
            try {
                cache.put("DataSorted", future.get());
            } catch (InterruptedException e) {
                Log.error(e.getMessage());
            } catch (ExecutionException e) {
                Log.error(e.getMessage());
            }
        }

        for(int i = 0; i < AVERAGE_CALCULATIONS; i++) {
            Future<Long> future = new AverageTime().averageTimeInsertionSort(dataReverseSorted);
            try {
                cache.put("DataReverseSorted", future.get());
            } catch (InterruptedException e) {
                Log.error(e.getMessage());
            } catch (ExecutionException e) {
                Log.error(e.getMessage());
            }
        }


    }

}
