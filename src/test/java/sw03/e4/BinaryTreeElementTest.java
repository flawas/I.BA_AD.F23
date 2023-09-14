package sw03.e4;

import com.sun.source.tree.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeElementTest {

    @Test
    void getData() {
        BinaryTreeElement binaryTreeElement = new BinaryTreeElement(5);
        assertEquals(5, binaryTreeElement.getData());
    }

    @Test
    void testEqualsTrue() {
        BinaryTreeElement binaryTreeElement1 = new BinaryTreeElement(5);
        BinaryTreeElement binaryTreeElement2 = new BinaryTreeElement(5);
        assertTrue(binaryTreeElement1.equals(binaryTreeElement2));
    }

    @Test
    void testEqualsFalse() {
        BinaryTreeElement binaryTreeElement1 = new BinaryTreeElement(5);
        BinaryTreeElement binaryTreeElement2 = new BinaryTreeElement(7);
        assertFalse(binaryTreeElement1.equals(binaryTreeElement2));
    }

    @Test
    void testHashCode() {
        BinaryTreeElement binaryTreeElement = new BinaryTreeElement(35);
        assertEquals(35, binaryTreeElement.hashCode());
    }
}