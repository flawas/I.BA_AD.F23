package sw02.e2;

import java.util.List;

public class ListElement {

    private final String data;
    private ListElement nextElement;

    public ListElement(final String data) {
        this.data = data;
    }

    public ListElement getNextElement() {
        return nextElement;
    }

    public void setNextElement(ListElement nextElement) {
        this.nextElement = nextElement;
    }

    public String getData() {
        return data;
    }

    @Override
    public final boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof ListElement p)) {
            return false;
        }
        return (p.getData().equals(this.getData()));
    }

    @Override
    public final int hashCode() {
        return getData().hashCode();
    }
}
