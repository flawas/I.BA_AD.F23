package sw03.e3;

/**
 * The TreeInterface provides a contract for working with tree structures.
 * It defines methods for adding and removing tree nodes, as well as checking
 * if a specific tree node exists in the tree.
 */
public interface TreeInterface {

    /**
     * Adds a new tree node to the tree.
     *
     * @param treeNode The TreeNode to be added to the tree.
     */
    public void addTreeNode(TreeNode treeNode);

    /**
     * Removes and returns a tree node from the tree.
     *
     * @return The TreeNode removed from the tree, or null if the tree is empty.
     */
    public TreeNode removeTreeNode();

    /**
     * Checks if a specific tree node exists in the tree.
     *
     * @param treeNode The TreeNode to be checked for existence in the tree.
     * @return true if the given TreeNode exists in the tree, false otherwise.
     */
    public boolean existsTreeNode(TreeNode treeNode);
}
