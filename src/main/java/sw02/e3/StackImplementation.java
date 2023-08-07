package sw02.e3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * The StackImplementation class implements the StackInterface and provides methods to work with a stack data structure.
 * It allows pushing elements onto the stack, popping elements from the stack, getting the current size of the stack,
 * and checking if the stack is full.
 */
public class StackImplementation implements StackInterface {

    /**
     * The maximum capacity of the stack.
     */
    private static int STORAGE_CAPACITY = 5;

    /**
     * ArrayList to store the elements of the stack.
     */
    ArrayList<StackElement> stackStorage = new ArrayList<>();

    /**
     * Logger for logging information and errors.
     */
    private static final Logger Log = LogManager.getLogger();

    /**
     * Default constructor for the StackImplementation class.
     */
    public StackImplementation() {
    }

    /**
     * Adds a new element to the top of the stack.
     *
     * @param stackElement The StackElement to be added to the stack.
     */
    @Override
    public void push(StackElement stackElement) {
        if (!this.isFull()) {
            stackStorage.add(stackElement);
        } else {
            Log.error("Stack is full.");
        }
    }

    /**
     * Removes and returns the element from the top of the stack.
     *
     * @return The StackElement removed from the top of the stack.
     */
    @Override
    public StackElement pop() {
        StackElement returnElement = stackStorage.get(stackStorage.size() - 1);
        stackStorage.remove(stackStorage.size() - 1);
        return returnElement;
    }

    /**
     * Returns the current size of the stack.
     *
     * @return The size of the stack.
     */
    public int getStackSize() {
        return stackStorage.size();
    }

    /**
     * Checks if the stack is full.
     *
     * @return True if the stack is full, false otherwise.
     */
    public boolean isFull() {
        return stackStorage.size() == STORAGE_CAPACITY;
    }

    /**
     * Main method for testing the stack functionality and logging the results.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        StackImplementation stackImplementation = new StackImplementation();
        stackImplementation.push(new StackElement("toll"));
        stackImplementation.push(new StackElement("sind"));
        stackImplementation.push(new StackElement("Datenstrukturen"));
        Log.info(stackImplementation.pop().getText());
        Log.info(stackImplementation.pop().getText());
        Log.info(stackImplementation.pop().getText());
    }
}

