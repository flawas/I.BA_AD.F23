package sw04.e1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

import static java.util.Objects.hash;

/**
 * A simple implementation of a hash table using an ArrayList for storage.
 */
public class SimpleHashTable implements SimpleHashTableInterface {

    /**
     * The initial capacity of the hash table.
     */
    private int INITIAL_CAPACITY = 10;

    /**
     * The underlying ArrayList to store hash table elements.
     */
    private ArrayList<SimpleHashElement> arrayList = new ArrayList<>();

    /**
     * Logger for logging debug information.
     */
    private static final Logger Log = LogManager.getLogger();

    /**
     * Constructs a new SimpleHashTable with initial capacity and initializes the array.
     */
    public SimpleHashTable() {
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            arrayList.add(new SimpleHashElement(""));
        }
    }

    /**
     * Adds a hash element to the hash table.
     *
     * @param hashElement The SimpleHashElement to be added.
     */
    @Override
    public void add(SimpleHashElement hashElement) {
        int index = hash(hashElement.hashCode()) % INITIAL_CAPACITY;
        if (!arrayList.get(index).getData().isEmpty()) {
            Log.error("Element already set at index " + index);
            return;
        }
        arrayList.set(index, hashElement);
    }

    /**
     * Retrieves the hash element at the specified index.
     *
     * @param index The index of the hash element to retrieve.
     * @return The SimpleHashElement at the specified index.
     */
    @Override
    public SimpleHashElement get(int index) {
        return arrayList.get(index);
    }

    /**
     * Removes the hash element at the specified index.
     *
     * @param index The index of the hash element to remove.
     * @return The removed SimpleHashElement, or an empty element if no element was found.
     */
    @Override
    public SimpleHashElement remove(int index) {
        if (!arrayList.get(index).getData().isEmpty()) {
            SimpleHashElement returnElement = arrayList.get(index);
            arrayList.set(index, new SimpleHashElement(""));
            return returnElement;
        } else {
            Log.debug("No element found at index " + index);
            return new SimpleHashElement("");
        }
    }
}
