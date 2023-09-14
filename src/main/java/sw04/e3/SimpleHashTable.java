package sw04.e3;

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
        int index = Math.abs(hash(hashElement.hashCode()) % INITIAL_CAPACITY);
        //if(arrayList.get(index).equals(hashElement)) {
        //    Log.error("same Element exists");
        //    return;
        //}
        if (!arrayList.get(index).getData().isEmpty()) {
            int i = index;
            while(!listPlaceisEmpty(i) && !arrayList.get(i).isThumbstone()) {
                Log.debug("Sondieren am Index: " + i);
                if(i == INITIAL_CAPACITY - 1) {
                    i = 0;
                } else {
                    i++;
                }
            }
            if(arrayList.get(i).isThumbstone()) {
                arrayList.set(i, hashElement);
            } else {
                arrayList.set(i, hashElement);
            }
            return;
        }
        arrayList.set(index, hashElement);
    }

    @Override
    public boolean search(SimpleHashElement simpleHashElement) {
        int index = Math.abs(hash(simpleHashElement.hashCode()) % INITIAL_CAPACITY);
        if(arrayList.get(index).equals(simpleHashElement)) {
            return true;
        } else {
            int i = index;
            while(!listPlaceisEmpty(i) && arrayList.get(i).hashCode() == simpleHashElement.hashCode()) {
                Log.debug("Sondieren am Index: " + i);
                if(i == INITIAL_CAPACITY - 1) {
                    i = 0;
                } else {
                    i++;
                }
            }
            if(arrayList.get(i).equals(simpleHashElement)) {
                return true;
            } else {
                return false;
            }
        }

    }

    /**
     * Removes the hash element at the specified index.
     *
     * @param index The index of the hash element to remove.
     * @return The removed SimpleHashElement, or an empty element if no element was found.
     */
    @Override
    public SimpleHashElement remove(int index) {
        if (!arrayList.get(index).getData().isEmpty() && !arrayList.get(index).isThumbstone()) {
            SimpleHashElement returnElement = arrayList.get(index);
            arrayList.get(index).setThumbstone(true);
            return returnElement;
        } else {
            int i = index;
            while(arrayList.get(i).isThumbstone()) {
                Log.debug("Sondieren am Index: " + i);
                if(i == INITIAL_CAPACITY - 1) {
                    i = 0;
                } else {
                    i++;
                }
            }
            arrayList.get(i).setThumbstone(true);
            return arrayList.get(i);
        }
    }

    private boolean listPlaceisEmpty(int index) {
        if(arrayList.get(index).equals(new SimpleHashElement(""))) {
            return true;
        }
        return false;
    }
}
