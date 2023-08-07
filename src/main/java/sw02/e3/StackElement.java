package sw02.e3;


/**
 * The StackElement class represents an element in a stack data structure. It contains a single piece of data
 * and provides a method to retrieve the data.
 */
public class StackElement {
    /**
     * The data stored in the StackElement.
     */
    private String data;

    /**
     * Constructs a new StackElement with the given data.
     *
     * @param data The data to be stored in the StackElement.
     */
    public StackElement(final String data) {
        this.data = data;
    }

    /**
     * Gets the data stored in the StackElement.
     *
     * @return The data stored in the StackElement.
     */
    public String getText() {
        return data;
    }
}

