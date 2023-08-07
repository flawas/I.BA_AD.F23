package sw02.e3;

/**
 * The StackInterface defines the contract for a stack data structure.
 * It provides methods for pushing elements onto the stack and popping elements from the stack.
 */
public interface StackInterface {

    /**
     * Pushes a new element onto the top of the stack.
     *
     * @param stackElement The StackElement to be added to the stack.
     */
    public void push(StackElement stackElement);

    /**
     * Removes and returns the element from the top of the stack.
     *
     * @return The StackElement removed from the top of the stack.
     */
    public StackElement pop();
}
