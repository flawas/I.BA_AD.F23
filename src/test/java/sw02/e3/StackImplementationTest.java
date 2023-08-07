package sw02.e3;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class StackImplementationTest {

    @Test
    void testStackEmpty() {
        StackImplementation stackImplementation = new StackImplementation();
        assertEquals(0, stackImplementation.getStackSize());
    }

    @Test
    void testPushOne() {
        StackImplementation stackImplementation = new StackImplementation();
        stackImplementation.push(new StackElement("Test"));
        assertEquals(1, stackImplementation.getStackSize());
    }

    @Test
    void testPop() {
        StackImplementation stackImplementation = new StackImplementation();
        stackImplementation.push(new StackElement("toll"));
        stackImplementation.push(new StackElement("sind"));
        stackImplementation.push(new StackElement("Datenstrukturen"));
        assertEquals(new StackElement("Datenstrukturen").getText(), stackImplementation.pop().getText());
        assertEquals(new StackElement("sind").getText(), stackImplementation.pop().getText());
        assertEquals(new StackElement("toll").getText(), stackImplementation.pop().getText());
    }

    @Test
    void getStackSize() {
        StackImplementation stackImplementation = new StackImplementation();
        stackImplementation.push(new StackElement("Test"));
        stackImplementation.push(new StackElement("Test"));
        stackImplementation.push(new StackElement("Test"));
        assertEquals(3, stackImplementation.getStackSize());
    }

    @Test
    void isFull() {
        StackImplementation stackImplementation = new StackImplementation();
        stackImplementation.push(new StackElement("Test"));
        stackImplementation.push(new StackElement("Test"));
        stackImplementation.push(new StackElement("Test"));
        stackImplementation.push(new StackElement("Test"));
        stackImplementation.push(new StackElement("Test"));
        assertTrue(stackImplementation.isFull());
    }
}