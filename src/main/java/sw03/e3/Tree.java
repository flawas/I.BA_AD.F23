package sw03.e3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tree implements TreeInterface {

    /**
     * The root of the binary search tree. This private field represents the topmost
     * node of the tree, from which all other nodes are accessible by traversing the
     * left and right child references. If the tree is empty, the root is set to null.
     * When nodes are added to the tree, the root is updated accordingly based on the
     * binary search tree insertion algorithm. The root is the starting point for any
     * tree operations and is a crucial element in maintaining the tree's structure.
     * It is accessed and modified through appropriate methods of the TreeInterface
     * implementation.
     */
    private TreeNode root = null;

    /**
     * Logger for logging information and errors.
     */
    private static final Logger Log = LogManager.getLogger();

    /**
     * Adds a new TreeNode to the binary search tree. The method follows the rules
     * of binary search tree insertion, where nodes with smaller values are placed
     * to the left, and nodes with larger values are placed to the right. If the
     * tree is currently empty (no root node exists), the new TreeNode becomes the
     * root of the tree. If the tree already contains elements, the method traverses
     * the tree starting from the root and searches for the appropriate position to
     * insert the new node based on its value. The method ensures that the binary
     * search tree property is maintained after insertion. If a TreeNode with the same
     * value as the inserted node already exists in the tree, the behavior of this
     * method may vary based on the specific implementation or requirements.
     *
     * @param treeNode The TreeNode to be added to the binary search tree.
     */
    @Override
    public void addTreeNode(TreeNode treeNode) {
        if(this.root == null) {
            this.root = treeNode;
        } else {
            TreeNode element = root;

            // Handle the case where the new node's value is smaller.
            if(treeNode.getData() < element.getData()) {
                if(element.getChildLeft() == null) {
                    element.setChildLeft(treeNode);
                    return;
                } else {
                    while(element.hasChildLeft() && treeNode.getData() < element.getData()) {
                        element = element.getChildLeft();
                    }
                    if(treeNode.getData() < element.getData() && element.hasChildLeft() == false) {
                        element.setChildLeft(treeNode);
                        return;
                    } else if (treeNode.getData() > element.getData() && element.hasChildRight() == false) {
                        element.setChildRight(treeNode);
                        return;
                    } else {
                        while(treeNode.getData() > element.getData() && element.hasChildRight()) {
                            element = element.getChildRight();
                        }
                        if(treeNode.getData() > element.getData() && element.hasChildRight() == false) {
                            element.setChildRight(treeNode);
                        } else if(treeNode.getData() < element.getData() && element.hasChildLeft() == false) {
                            element.setChildLeft(treeNode);
                        }
                    }
                }
            }

            // Handle the case where the new node's value is larger.
            if(treeNode.getData() > element.getData()) {
                if(element.getChildRight() == null) {
                    element.setChildRight(treeNode);
                    return;
                } else {
                    while(element.hasChildRight() && treeNode.getData() > element.getData()) {
                        element = element.getChildRight();
                    }
                    if(treeNode.getData() > element.getData() && element.hasChildRight() == false) {
                        element.setChildRight(treeNode);
                        return;
                    } else if (treeNode.getData() < element.getData() && element.hasChildLeft() == false) {
                        element.setChildLeft(treeNode);
                        return;
                    } else {
                        while(treeNode.getData() < element.getData() && element.hasChildLeft()) {
                            element = element.getChildLeft();
                        }
                        if(treeNode.getData() < element.getData() && element.hasChildLeft() == false) {
                            element.setChildLeft(treeNode);
                        } else if(treeNode.getData() > element.getData() && element.hasChildRight() == false) {
                            element.setChildRight(treeNode);
                        }
                    }
                }
            }
        }
    }

    /**
     * Retrieves the root node of the binary search tree. The root node represents
     * the topmost node in the tree, from which all other nodes are accessible by
     * traversing the left and right child references. If the tree is empty, the
     * method will return null, indicating that there is no root node. The root is
     * a crucial element in maintaining the structure of the binary search tree, and
     * it serves as the starting point for various tree operations. By accessing the
     * root node, users can perform operations on the entire tree, including adding,
     * removing, or searching for specific elements. The returned TreeNode object can
     * be used to manipulate the root node or access its data and child nodes.
     *
     * @return The root node of the binary search tree, or null if the tree is empty.
     */
    public TreeNode getRoot() {
        return root;
    }

    public String getTree() {
        String returnString = "";

        TreeNode elementRoot = root;
        TreeNode element = root;

        while(element.hasChildLeft()) {
            returnString = returnString + "," + element.getData();
            element = element.getChildLeft();
        }


        return returnString;
    }

    /**
     * Removes and returns a tree node from the tree.
     *
     * @return The TreeNode removed from the tree, or null if the tree is empty.
     */
    @Override
    public TreeNode removeTreeNode() {
        return null;
    }

    /**
     * Checks if a specific tree node exists in the tree.
     *
     * @param treeNode The TreeNode to be checked for existence in the tree.
     * @return true if the given TreeNode exists in the tree, false otherwise.
     */
    @Override
    public boolean existsTreeNode(TreeNode treeNode) {
        return false;
    }
}
