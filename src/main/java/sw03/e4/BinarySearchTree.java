package sw03.e4;

import com.sun.source.tree.BinaryTree;

public class BinarySearchTree implements BinaryTreeInterface{

    BinaryTreeElement root = null;

    @Override
    public boolean addTreeElement(BinaryTreeElement binaryTreeElement) {
        if(!containsTreeElement(binaryTreeElement) && this.root == null) {
            this.root = binaryTreeElement;
            return true;
        }

        BinaryTreeElement binarySearchElement = this.root;
        while (binaryTreeElement.hashCode() < binarySearchElement.hashCode() && binarySearchElement.getChildLeft() != null) {
            binarySearchElement = binarySearchElement.getChildLeft();
        }

        while(binaryTreeElement.hashCode() > binarySearchElement.hashCode() && binarySearchElement.getChildRight() != null) {
            binarySearchElement = binarySearchElement.getChildRight();
        }

        if (binaryTreeElement.hashCode() < binarySearchElement.hashCode() && binaryTreeElement.getChildLeft() == null) {
            binarySearchElement.setChildLeft(binaryTreeElement);
            return true;
        }

        if(binaryTreeElement.hashCode() > binarySearchElement.hashCode() && binaryTreeElement.getChildRight() == null) {
            binarySearchElement.setChildRight(binaryTreeElement);
        }


        return false;
    }

    @Override
    public boolean removeTreeElement(BinaryTreeElement binaryTreeElement) {
        return false;
    }

    @Override
    public boolean containsTreeElement(BinaryTreeElement binaryTreeElement) {
        // if root is not null
        if(this.root == null) {
            return false;
        }

        // if root is searched element
        if(this.root.hashCode() == binaryTreeElement.hashCode()) {
            return true;
        }


        BinaryTreeElement binarySearchElement = this.root;
        while (binaryTreeElement.hashCode() < binarySearchElement.hashCode() && binarySearchElement.getChildLeft() != null) {
            binarySearchElement = binarySearchElement.getChildLeft();
        }

        while(binaryTreeElement.hashCode() > binarySearchElement.hashCode() && binarySearchElement.getChildRight() != null) {
            binarySearchElement = binarySearchElement.getChildRight();
        }

        if(binarySearchElement.hashCode() == binaryTreeElement.hashCode()) {
            return true;
        }


        return false;
    }
}
