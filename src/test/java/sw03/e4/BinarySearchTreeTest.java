package sw03.e4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void addTreeElement() {
    }

    @Test
    void removeTreeElement() {
    }

    @Test
    void containsTreeElementRoot() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addTreeElement(new BinaryTreeElement(10));
        assertTrue(binarySearchTree.containsTreeElement(new BinaryTreeElement(10)));
    }

    @Test
    void containsTreeElementTreeLeft() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addTreeElement(new BinaryTreeElement(10));
        binarySearchTree.addTreeElement(new BinaryTreeElement(5));
        binarySearchTree.addTreeElement(new BinaryTreeElement(1));
        binarySearchTree.addTreeElement(new BinaryTreeElement(7));
        binarySearchTree.addTreeElement(new BinaryTreeElement(15));
        binarySearchTree.addTreeElement(new BinaryTreeElement(11));
        binarySearchTree.addTreeElement(new BinaryTreeElement(20));
        assertTrue(binarySearchTree.containsTreeElement(new BinaryTreeElement(20)));
    }
}