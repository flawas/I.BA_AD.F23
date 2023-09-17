/*
 * Copyright 2023 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sw11.quicksort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
@SuppressWarnings("serial")
public final class QuicksortTask extends RecursiveAction {

    private static int THRESHOLD = 1;
    private final int[] array;
    private final int min;
    private final int max;

    /**
     * Erzeugt einen Array-Sortier Task.
     *
     * @param array Interger-Array.
     */
    public QuicksortTask(int[] array) {
        this(array, 0, array.length - 1);
    }

    private QuicksortTask(final int[] array, final int min, final int max) {
        this.array = array;
        this.min = min;
        this.max = max;
    }

    public QuicksortTask(final int array[], final int min, final int max, final int threshold) {
        this.array = array;
        this.min = min;
        this.max = max;
        this.THRESHOLD = threshold;
    }

    @Override
    protected void compute() {
        int up = min;
        int down = max - 1;
        int t = array[max];
        do {
            while (array[up] < t) {
                up++;
            }
            while (array[down] >= t && down > up) {
                down--;
            }
            if (up < down) {
                exchange(array, up, down);
            }
        } while (up < down);

        exchange(array, up, max);

        List<QuicksortTask> tasks = new ArrayList<>();

        if (min < up - 1) {
            int size = (up - 1) - min + 1;
            if (size < THRESHOLD) {
                Arrays.sort(array, min, up);
            } else {
                tasks.add(new QuicksortTask(array, min, up - 1, THRESHOLD));
            }
        }

        if (max > up + 1) {
            int size = max - (up + 1) + 1;
            if (size < THRESHOLD) {
                Arrays.sort(array, up + 1, max + 1);
            } else {
                tasks.add(new QuicksortTask(array, up + 1, max, THRESHOLD));
            }
        }

        if (!tasks.isEmpty()) {
            invokeAll(tasks);
        }
    }

    /**
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param data        Zeichen‐Array
     * @param firstIndex  Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private static void exchange(final int data[], final int firstIndex, final int secondIndex) {
        int tmp = data[firstIndex];
        data[firstIndex] = data[secondIndex];
        data[secondIndex] = tmp;
    }
}
