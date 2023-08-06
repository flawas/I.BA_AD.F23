package sw02.e2;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListElementTest {

    @Test
    void getNextElement() {
        ListElement followingElement = new ListElement("Test Following Element");
        ListElement listElement = new ListElement("Test");
        listElement.setNextElement(followingElement);
        assertEquals("Test Following Element", listElement.getNextElement().getData());
    }

    @Test
    void getData() {
        ListElement listElement = new ListElement("Test");
        assertEquals("Test", listElement.getData());
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(ListElement.class).withPrefabValues(ListElement.class, new ListElement("Test 1"), new ListElement("Test 2")).withNonnullFields("data").withIgnoredFields("nextElement").verify();
    }

    @Test
    void testEqualsTrue() {
        ListElement listElement1 = new ListElement("Test");
        ListElement listElement2 = new ListElement("Test");
        assertTrue(listElement1.equals(listElement2));
    }

    @Test
    void testEqualsFalse() {
        ListElement listElement1 = new ListElement("Test");
        ListElement listElement2 = new ListElement("Test 1");
        assertFalse(listElement1.equals(listElement2));
    }

    @Test
    void testHashCode() {
        ListElement listElement = new ListElement("Test");
        assertEquals(2603186, listElement.hashCode());
    }
}