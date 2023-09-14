package sw04.e1;

import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashElementTest {

    @Test
    void getData() {
        SimpleHashElement simpleHashElement = new SimpleHashElement("Test");
        assertEquals("Test", simpleHashElement.getData());
    }

    @Test
    void testEqualsTrue() {
        SimpleHashElement simpleHashElement1 = new SimpleHashElement("Test 1");
        SimpleHashElement simpleHashElement2 = new SimpleHashElement("Test 1");
        assertTrue(simpleHashElement2.equals(simpleHashElement1));
    }

    @Test
    void testEqualsFalse() {
        SimpleHashElement simpleHashElement1 = new SimpleHashElement("Test 1");
        SimpleHashElement simpleHashElement2 = new SimpleHashElement("Test 2)");
        assertFalse(simpleHashElement2.equals(simpleHashElement1));
    }

    @Test
    void testHashCode() {
        SimpleHashElement simpleHashElement = new SimpleHashElement("Test");
        assertEquals(2603186, simpleHashElement.hashCode());
    }

    @Test
    void testToString() {
        SimpleHashElement simpleHashElement = new SimpleHashElement("Test");
        assertEquals("SimpleHashElement{data=Test,hashCode=2603186}", simpleHashElement.toString());
    }
}