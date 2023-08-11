package sw03.e3;

public class TreeNode {

    private char data;
    private TreeNode childRight;
    private TreeNode childLeft;

    public TreeNode(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }

    public TreeNode getChildRight() {
        return childRight;
    }

    public boolean hasChildRight() {
        return this.childRight != null;
    }

    public void setChildRight(TreeNode childRight) {
        this.childRight = childRight;
    }

    public TreeNode getChildLeft() {
        return childLeft;
    }

    public boolean hasChildLeft() {
        return this.childLeft != null;
    }

    public void setChildLeft(TreeNode childLeft) {
        this.childLeft = childLeft;
    }

    public boolean isLeaf() {
        return this.childRight != null && this.childRight != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode treeNode)) return false;

        return getData() == treeNode.getData();
    }

    @Override
    public int hashCode() {
        return getData();
    }
}
