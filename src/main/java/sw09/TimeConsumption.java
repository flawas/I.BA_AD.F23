package sw09;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sw09.e4.InsertionSort;
import sw09.e5.BubbleSort;
import sw09.e6.ShellSort;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TimeConsumption {

    private volatile Map<String, Long> cache = new HashMap<>();

    private static int ANZAHL_TESTS = 10;
    private static int ANZAHL_ZAHLEN = 1_000;
    private static int RANDOM_MAX = 100000;
    private static int RANDOM_MIN = 1;
    private int [] array;
    private static final Logger Log = LogManager.getLogger();
    ExecutorService executorService = Executors.newCachedThreadPool();

    public TimeConsumption() {

        this.array = new int[ANZAHL_ZAHLEN];
        for(int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * (RANDOM_MAX - RANDOM_MIN)) + RANDOM_MIN);
        }
        Log.debug(printArray());

    }

    public void testInsertionSort() {
        executorService.execute(() -> {
            // InsertionSort
            for(int i = 0; i < ANZAHL_TESTS; i++) {
                long startTime = System.currentTimeMillis();
                new InsertionSort(array.clone()).insertionSort2Modified();
                long endTime = System.currentTimeMillis();
                cache.put("InsertionSort"+i, (endTime-startTime));
            }
        });
    }

    public void testShellSort() {
        executorService.execute(() -> {
            // Shell Sort
            for(int i = 0; i < ANZAHL_TESTS; i++) {
                long startTime = System.currentTimeMillis();
                new ShellSort(array.clone()).shellsort();
                long endTime = System.currentTimeMillis();
                cache.put("ShellSort"+i, (endTime-startTime));
            }
        });
    }

    public void testBubbleSort() {
        executorService.execute(() -> {
            // Bubble Sort
            for(int i = 0; i < ANZAHL_TESTS; i++) {
                long startTime = System.currentTimeMillis();
                new BubbleSort(array.clone()).selectionSort();
                long endTime = System.currentTimeMillis();
                cache.put("BubbleSort"+i, (endTime-startTime));
            }
        });
    }

    private double getAveragePerformances(final String type) {
        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Log.error(ex.getMessage());
        }

        long sum = 0;
        for (int i = 0; i < cache.size(); i++) {
            if(cache.get(type + i) != null) {
                sum += cache.get(type + i);
            }
        }
        return (double) sum / ANZAHL_TESTS;
    }

    private String getPerformances(final String type) {
        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Log.error(ex.getMessage());
        }
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < cache.size(); i++) {
            returnString.append(", ").append(cache.get(type + i));
        }
        return returnString.toString();
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
        TimeConsumption timeConsumption = new TimeConsumption();
        timeConsumption.testBubbleSort();
        timeConsumption.testInsertionSort();
        timeConsumption.testShellSort();

        Log.info("Zeitangaben in Millisekunden");
        Log.info("Average ShellSort: " + timeConsumption.getAveragePerformances("ShellSort"));
        Log.info("Average InsertionSort: " + timeConsumption.getAveragePerformances("InsertionSort"));
        Log.info("Average BubbleSort: " + timeConsumption.getAveragePerformances("BubbleSort"));
    }

}
