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

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
public class QuicksortRecursive {

    /**
     * public method exposed to client, sorts given array using QuickSort
     * Algorithm in Java.
     *
     * @param array input array.
     */
    public static void quicksort(int[] array) {
        QuicksortRecursive.quicksort(array, 0, array.length - 1);
    }

    public static final void quicksort(final int[] array, final int min, final int max) {
        medianOfThree(array, min, max);
        int up = min;
        int down = max - 1; // rechte Grenze (ohne Trennelement)
        int pivot = array[max]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (array[up] < pivot) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((array[down] > pivot) && (down > up)) {
                down--; // suche echt kleineres (<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                exchange(array, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchange(array, up, max); // Trennelement an endgültige Position (a[up])
        if (min < (up - 1)) {
            quicksort(array, min, (up - 1)); // linke Hälfte
        }
        if ((up + 1) < max) {
            quicksort(array, (up + 1), max); // rechte Hälfte, ohne T’Elt.
        }
    }

    private static void medianOfThree(final int[] array, final int min, final int max) {
        final int mid = (max + min) / 2;
        if (array[min] > array[max] && array[min] > array[mid]) {
            exchange(array, min, max);
        } else if (array[mid] > array[max]) {
            exchange(array, mid, max);
        }
    }

    private static void exchange(final int[] array, final int i, final int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
