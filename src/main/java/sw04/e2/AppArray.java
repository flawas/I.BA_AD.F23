package sw04.e2;

import java.util.ArrayList;

/**
 * Represents an application using an ArrayList to store integers.
 */
public class AppArray {

    /**
     * The ArrayList used to store integers.
     */
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();

    /**
     * Constructs an AppArray and initializes it with integers from 0 to (capacity - 1).
     *
     * @param capacity The capacity of the ArrayList and the number of integers to initialize.
     */
    public AppArray(final int capacity) {
        for (int i = 0; i < capacity; i++) {
            arrayList.add(i);
        }
    }
}