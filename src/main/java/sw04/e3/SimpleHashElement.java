package sw04.e3;

import java.util.Objects;

/**
 * Represents a simple element that can be stored in a hash table.
 */
public class SimpleHashElement {

    private String data;
    private boolean thumbstone = false;

    /**
     * Constructs a new SimpleHashElement with the provided data.
     *
     * @param data The data to be stored in the element.
     */
    public SimpleHashElement(String data) {
        this.data = data;
    }

    /**
     * Gets the data stored in the element.
     *
     * @return The data stored in the element.
     */
    public String getData() {
        return data;
    }

    public void setThumbstone(boolean thumbstone) {
        this.thumbstone = thumbstone;
    }

    public boolean isThumbstone() {
        return thumbstone;
    }

    /**
     * Checks whether this element is equal to the given object.
     *
     * @param o The object to compare with this element.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public final boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SimpleHashElement p)) {
            return false;
        }
        return Objects.equals(p.getData(), this.getData());
    }

    /**
     * Computes the hash code of the element based on its data.
     *
     * @return The computed hash code.
     */
    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    /**
     * Generates a string representation of the element.
     *
     * @return The string representation of the element.
     */
    @Override
    public String toString() {
        return "SimpleHashElement{" +
                "data=" + data + "," + "hashCode=" + hashCode() +
                '}';
    }
}