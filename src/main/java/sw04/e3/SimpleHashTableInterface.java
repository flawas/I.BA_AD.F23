package sw04.e3;

/**
 * Interface representing a simple hash table.
 */
public interface SimpleHashTableInterface {

    public void add(SimpleHashElement hashElement);

    public boolean search(SimpleHashElement simpleHashElement);

    public SimpleHashElement remove(final int index);
}
