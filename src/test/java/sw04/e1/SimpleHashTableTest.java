package sw04.e1;

import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashTableTest {

    @Test
    void add() {
        SimpleHashTable simpleHashTable = new SimpleHashTable();
        simpleHashTable.add(new SimpleHashElement("Test"));
        assertEquals("Test", simpleHashTable.get(7).getData());
    }

    @Test
    void get() {
        SimpleHashTable simpleHashTable = new SimpleHashTable();
        simpleHashTable.add(new SimpleHashElement("Test"));
        assertEquals("Test", simpleHashTable.get(7).getData());
    }

    @Test
    void collision() {
        SimpleHashTable simpleHashTable = new SimpleHashTable();
        simpleHashTable.add(new SimpleHashElement("Test"));
        simpleHashTable.add(new SimpleHashElement("Test"));
        assertEquals("Test", simpleHashTable.get(7).getData());
    }

    @Test
    void removeElement() {
        SimpleHashTable simpleHashTable = new SimpleHashTable();
        simpleHashTable.add(new SimpleHashElement("Test"));
        assertEquals("Test", simpleHashTable.remove(7).getData());
    }

    @Test
    void removeNoElement() {
        SimpleHashTable simpleHashTable = new SimpleHashTable();
        simpleHashTable.add(new SimpleHashElement("Test"));
        assertEquals("", simpleHashTable.remove(2).getData());
    }
}