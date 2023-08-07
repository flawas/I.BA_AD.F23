package sw02.e2;


/**
 * The ListElement class represents an element in a singly linked list.
 * Each ListElement contains a data value and a reference to the next ListElement in the list.
 */
public class ListElement {

    /**
     * The data stored in this ListElement.
     */
    private final String data;

    /**
     * Reference to the next ListElement in the linked list.
     */
    private ListElement nextElement;

    /**
     * Creates a new ListElement with the specified data.
     *
     * @param data The data to be stored in the ListElement.
     */
    public ListElement(final String data) {
        this.data = data;
    }

    /**
     * Gets the next ListElement in the linked list.
     *
     * @return The next ListElement or null if there is no next element.
     */
    public ListElement getNextElement() {
        return nextElement;
    }

    /**
     * Sets the next ListElement in the linked list.
     *
     * @param nextElement The ListElement to be set as the next element.
     */
    public void setNextElement(ListElement nextElement) {
        this.nextElement = nextElement;
    }

    /**
     * Gets the data stored in this ListElement.
     *
     * @return The data stored in this ListElement.
     */
    public String getData() {
        return data;
    }

    /**
     * Compares this ListElement to the specified object.
     *
     * @param o The object to compare this ListElement against.
     * @return true if the objects are equal (both ListElements have the same data), false otherwise.
     */
    @Override
    public final boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof ListElement p)) {
            return false;
        }
        return (p.getData().equals(this.getData()));
    }

    /**
     * Generates a hash code for this ListElement.
     *
     * @return The hash code for this ListElement based on its data.
     */
    @Override
    public final int hashCode() {
        return getData().hashCode();
    }
}
