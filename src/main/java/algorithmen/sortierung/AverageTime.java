package algorithmen.sortierung;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AverageTime {

    private int[] data;
    private ExecutorService executorService = Executors.newFixedThreadPool(4);

    public Future<Long> averageTimeInsertionSort(final int[] data) {
        return executorService.submit(() -> {
            long startTime = System.currentTimeMillis();
            InsertionSort.insertionSort(data);
            long endTime = System.currentTimeMillis();
            return (endTime - startTime);
        });
    }

}
