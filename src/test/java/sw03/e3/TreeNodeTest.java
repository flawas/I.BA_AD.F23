package sw03.e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    @Test
    void getData() {
        TreeNode treeNode = new TreeNode('A');
        assertEquals('A', treeNode.getData());
    }

    @Test
    void testEqualsTrue() {
        TreeNode treeNode1 = new TreeNode('A');
        TreeNode treeNode2 = new TreeNode('A');
        assertTrue(treeNode1.equals(treeNode2));
    }

    @Test
    void testEqualsFalse() {
        TreeNode treeNode1 = new TreeNode('A');
        TreeNode treeNode2 = new TreeNode('B');
        assertFalse(treeNode1.equals(treeNode2));
    }

    @Test
    void testHashCode() {
        TreeNode treeNode = new TreeNode('A');
        assertEquals(65, treeNode.hashCode());
    }

    @Test
    void getChildRight() {
        TreeNode treeNode = new TreeNode('B');
        treeNode.setChildRight(new TreeNode('C'));
        assertEquals('C', treeNode.getChildRight().getData());
    }

    @Test
    void hasChildRight() {
        TreeNode treeNode = new TreeNode('B');
        treeNode.setChildRight(new TreeNode('C'));
        assertTrue(treeNode.hasChildRight());
    }

    @Test
    void getChilfLeft() {
        TreeNode treeNode = new TreeNode('B');
        treeNode.setChildLeft(new TreeNode('A'));
        assertEquals('A', treeNode.getChildLeft().getData());
    }

    @Test
    void hasChildLeft() {
        TreeNode treeNode = new TreeNode('B');
        treeNode.setChildLeft(new TreeNode('A'));
        assertTrue(treeNode.hasChildLeft());
    }

    @Test
    void isLeafTrue() {
        TreeNode treeNode = new TreeNode('B');
        assertFalse(treeNode.isLeaf());
    }

    @Test
    void isLeafFalse() {
        TreeNode treeNode = new TreeNode('B');
        treeNode.setChildLeft(new TreeNode('A'));
        treeNode.setChildRight(new TreeNode('C'));
        assertTrue(treeNode.isLeaf());
    }
}