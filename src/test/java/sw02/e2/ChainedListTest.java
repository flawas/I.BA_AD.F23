package sw02.e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainedListTest {

    @Test
    void getListSizeOne() {
        ChainedList chainedList = new ChainedList();
        chainedList.newElement("Test");
        assertEquals(1, chainedList.getListSize());
    }

    @Test
    void getListSizeTwo() {
        ChainedList chainedList = new ChainedList();
        chainedList.newElement("Test");
        chainedList.newElement("Test 2");
        assertEquals(2, chainedList.getListSize());
    }

    @Test
    void newFirstElement() {
        ChainedList chainedList = new ChainedList();
        chainedList.newElement("Test");
        chainedList.newElement("Test 2");
        chainedList.newFirstElement("New First Element");
        assertEquals("New First Element", chainedList.getHead().getData());
    }

    @Test
    void searchElementFirst() {
        ChainedList chainedList = new ChainedList();
        chainedList.newElement("Test 1");
        chainedList.newElement("Test 2");
        chainedList.newElement("Test 3");
        assertTrue(chainedList.searchElement(new ListElement("Test 1")));
    }

    @Test
    void searchElementMiddle() {
        ChainedList chainedList = new ChainedList();
        chainedList.newElement("Test 1");
        chainedList.newElement("Test 2");
        chainedList.newElement("Test 3");
        assertTrue(chainedList.searchElement(new ListElement("Test 2")));
    }

    @Test
    void searchElementEnd() {
        ChainedList chainedList = new ChainedList();
        chainedList.newElement("Test 1");
        chainedList.newElement("Test 2");
        chainedList.newElement("Test 3");
        chainedList.newElement("Test 4");
        assertTrue(chainedList.searchElement(new ListElement("Test 4")));
    }

    @Test
    void searchElementFalse() {
        ChainedList chainedList = new ChainedList();
        chainedList.newElement("Test 1");
        chainedList.newElement("Test 2");
        chainedList.newElement("Test 3");
        assertFalse(chainedList.searchElement(new ListElement("Test 4")));
    }

    @Test
    void getAndRemoveFirstElement() {
        ChainedList chainedList = new ChainedList();
        chainedList.newElement("Test 1");
        chainedList.newElement("Test 2");
        chainedList.newElement("Test 3");
        assertEquals("Test 1", chainedList.getAndRemoveFirstElement().getData());
        assertEquals(2, chainedList.getListSize());
    }

    @Test
    void getAndRemoveAnyElenentFirst() {
        ChainedList chainedList = new ChainedList();
        chainedList.newElement("Test 1");
        chainedList.newElement("Test 2");
        chainedList.newElement("Test 3");
        assertEquals("Test 1", chainedList.getAndRemoveAnyElement(new ListElement("Test 1")).getData());
        assertEquals(2, chainedList.getListSize());
    }

    @Test
    void getAndRemoveAnyElementMiddle() {
        ChainedList chainedList = new ChainedList();
        chainedList.newElement("Test 1");
        chainedList.newElement("Test 2");
        chainedList.newElement("Test 3");
        assertEquals("Test 2", chainedList.getAndRemoveAnyElement(new ListElement("Test 2")).getData());
        assertEquals(2, chainedList.getListSize());
    }

    @Test
    void getAndRemoveAnyElementLast() {
        ChainedList chainedList = new ChainedList();
        chainedList.newElement("Test 1");
        chainedList.newElement("Test 2");
        chainedList.newElement("Test 3");
        assertEquals("Test 3", chainedList.getAndRemoveAnyElement(new ListElement("Test 3")).getData());
        assertEquals(2, chainedList.getListSize());
    }

    @Test
    void getAndRemoveAnyElementNotFound() {
        ChainedList chainedList = new ChainedList();
        chainedList.newElement("Test 1");
        chainedList.newElement("Test 2");
        chainedList.newElement("Test 3");
        assertEquals(new ListElement(""), chainedList.getAndRemoveAnyElement(new ListElement("Test 4")));
        assertEquals(3, chainedList.getListSize());
    }
}