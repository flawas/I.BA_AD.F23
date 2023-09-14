package sw04.e2;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Represents an application using a Deque (double-ended queue) to store integers.
 */
public class AppDeque {

    /**
     * The Deque used to store integers.
     */
    private Deque<Integer> deque = new ArrayDeque<Integer>();

    /**
     * Constructs an AppDeque and initializes it with integers from 0 to (capacity - 1).
     *
     * @param capacity The capacity of the Deque and the number of integers to initialize.
     */
    public AppDeque(final int capacity) {
        for (int i = 0; i < capacity; i++) {
            deque.push(i);
        }
    }
}
