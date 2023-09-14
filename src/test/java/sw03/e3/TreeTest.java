package sw03.e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void addTreeNodeRoot() {
        Tree tree = new Tree();
        tree.addTreeNode(new TreeNode('A'));
        assertEquals('A', tree.getRoot().getData());
    }

    @Test
    void addTreeNodeMultiple() {
        Tree tree = new Tree();
        tree.addTreeNode(new TreeNode('H'));
        tree.addTreeNode(new TreeNode('D'));
        tree.addTreeNode(new TreeNode('L'));
        assertEquals('H', tree.getRoot().getData());
    }

    @Test
    void addTreeNodeMultiple2() {
        Tree tree = new Tree();
        tree.addTreeNode(new TreeNode('H'));
        tree.addTreeNode(new TreeNode('D'));
        tree.addTreeNode(new TreeNode('L'));
        tree.addTreeNode(new TreeNode('B'));
        tree.addTreeNode(new TreeNode('F'));
        tree.addTreeNode(new TreeNode('J'));
        tree.addTreeNode(new TreeNode('N'));
        tree.addTreeNode(new TreeNode('A'));
        tree.addTreeNode(new TreeNode('C'));
        tree.addTreeNode(new TreeNode('E'));
        tree.addTreeNode(new TreeNode('G'));
        tree.addTreeNode(new TreeNode('I'));
        tree.addTreeNode(new TreeNode('K'));
        tree.addTreeNode(new TreeNode('M'));
        tree.addTreeNode(new TreeNode('O'));
        assertEquals('H', tree.getRoot().getData());
    }

    @Test
    void removeTreeNode() {
    }

    @Test
    void existsTreeNode() {
    }

    @Test
    void getTree() {
        Tree tree = new Tree();
        tree.addTreeNode(new TreeNode('H'));
        tree.addTreeNode(new TreeNode('D'));
        tree.addTreeNode(new TreeNode('L'));
        tree.addTreeNode(new TreeNode('B'));
        tree.addTreeNode(new TreeNode('F'));
        tree.addTreeNode(new TreeNode('J'));
        tree.addTreeNode(new TreeNode('N'));
        tree.addTreeNode(new TreeNode('A'));
        tree.addTreeNode(new TreeNode('C'));
        tree.addTreeNode(new TreeNode('E'));
        tree.addTreeNode(new TreeNode('G'));
        tree.addTreeNode(new TreeNode('I'));
        tree.addTreeNode(new TreeNode('K'));
        tree.addTreeNode(new TreeNode('M'));
        tree.addTreeNode(new TreeNode('O'));
        assertEquals(",H,D,B", tree.getTree());
    }
}