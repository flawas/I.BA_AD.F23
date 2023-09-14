package sw03.e4;

import java.util.Objects;

public class BinaryTreeElement {

    private int data;
    private BinaryTreeElement childLeft;
    private BinaryTreeElement childRight;

    public BinaryTreeElement(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BinaryTreeElement that)) return false;

        return getData() == that.getData();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.data);
    }

    public BinaryTreeElement getChildLeft() {
        return childLeft;
    }

    public void setChildLeft(BinaryTreeElement childLeft) {
        this.childLeft = childLeft;
    }

    public BinaryTreeElement getChildRight() {
        return childRight;
    }

    public void setChildRight(BinaryTreeElement childRight) {
        this.childRight = childRight;
    }
}
