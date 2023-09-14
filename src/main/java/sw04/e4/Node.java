package sw04.e4;

import static java.util.Objects.hash;

public class Node {

    private String data;
    private Node nextElement;

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public Node getNextElement() {
        return nextElement;
    }

    public void setNextElement(Node nextElement) {
        this.nextElement = nextElement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;

        return getData().equals(node.getData());
    }

    @Override
    public int hashCode() {
        return hash(this.data);
    }
}
