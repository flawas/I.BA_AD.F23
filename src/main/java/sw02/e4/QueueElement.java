package sw02.e4;

/**
 * The QueueElement class represents an element in a queue data structure. It contains a single character data and
 * provides a method to retrieve the data.
 */
public class QueueElement {

    /**
     * The character data stored in the QueueElement.
     */
    private char data;

    /**
     * Constructs a new QueueElement with the given character data.
     *
     * @param data The character data to be stored in the QueueElement.
     */
    public QueueElement(char data) {
        this.data = data;
    }

    /**
     * Gets the character data stored in the QueueElement.
     *
     * @return The character data stored in the QueueElement.
     */
    public char getData() {
        return data;
    }
}