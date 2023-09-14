package sw04.e1;

/**
 * Interface representing a simple hash table.
 */
public interface SimpleHashTableInterface {

    /**
     * Adds a SimpleHashElement to the hash table.
     *
     * @param hashElement The SimpleHashElement to be added.
     */
    public void add(SimpleHashElement hashElement);

    /**
     * Retrieves the SimpleHashElement at the specified index.
     *
     * @param index The index of the hash element to retrieve.
     * @return The SimpleHashElement at the specified index.
     */
    public SimpleHashElement get(final int index);

    /**
     * Removes the SimpleHashElement at the specified index.
     *
     * @param index The index of the hash element to remove.
     * @return The removed SimpleHashElement.
     */
    public SimpleHashElement remove(final int index);
}
