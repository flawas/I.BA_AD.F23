package sw04.e2;

import java.util.Stack;

/**
 * Represents an application using a Stack to store integers.
 */
public class AppStack {

    /**
     * The Stack used to store integers.
     */
    private final Stack<Integer> stack = new Stack<Integer>();

    /**
     * Constructs an AppStack and initializes it with integers from 0 to (capacity - 1).
     *
     * @param capacity The capacity of the Stack and the number of integers to initialize.
     */
    public AppStack(final int capacity) {
        for (int i = 0; i < capacity; i++) {
            stack.push(i);
        }
    }
}
