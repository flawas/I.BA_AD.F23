package sw02.e2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChainedList {

    private ListElement head;
    private int sizeCounter;
    private static final Logger Log = LogManager.getLogger();

    public void newElement(final String data) {

        // if head is null, set head with new element
        if(this.head == null) {
            this.head = new ListElement(data);
        } else {
            ListElement element = this.head;
            while(element.getNextElement() != null) {
                element = element.getNextElement();
            }
            element.setNextElement(new ListElement(data));
        }
    }

    public int getListSize() {
        sizeCounter = 0;
        ListElement elemenet = this.head;

        if(elemenet != null) {
            sizeCounter++;
        }
        while(elemenet.getNextElement() != null) {
            sizeCounter++;
            elemenet = elemenet.getNextElement();
        }
        return sizeCounter;
    }

    public void newFirstElement(final String data) {
        ListElement oldHead = this.head;
        this.head = new ListElement(data);
        this.head.setNextElement(oldHead);
    }

    public ListElement getHead() {
        return this.head;
    }

    public boolean searchElement(final ListElement listElement) {
        ListElement element = this.head;
        for(int i = 0; i < this.getListSize(); i++) {
            if(element.equals(listElement)){
                return true;
            }
            element = element.getNextElement();
        }
        return false;
    }

    public ListElement getAndRemoveFirstElement() {
        ListElement newHead = this.head.getNextElement();
        ListElement oldHead = this.head;
        this.head = newHead;
        return oldHead;
    }

    public ListElement getAndRemoveAnyElement(final ListElement listElement) {
        // check if element exists
        if(searchElement(listElement) == true) {

            // if first element
            if(this.head.equals(listElement)) {
                Log.debug("getAndRemoveAnyElement First");
                return this.getAndRemoveFirstElement();
            }

            // get the element before the element searched
            ListElement element = this.head;
            while(!element.getNextElement().equals(listElement)) {
                element = element.getNextElement();
            }
            // if in the middle
            if(element.getNextElement().equals(listElement) && element.getNextElement().getNextElement() != null) {
                Log.debug("getAndRemoveAnyElement Middle");
                ListElement followingElement = element.getNextElement().getNextElement();
                ListElement returnElement = element.getNextElement();
                element.setNextElement(followingElement);
                return returnElement;
            }

            // if at the end
            if(element.getNextElement().equals(listElement)) {
                Log.debug("getAndRemoveAnyElement End");
                ListElement returnElement = element.getNextElement();
                element.setNextElement(null);
                return returnElement;
            }
        }

        Log.debug("getAndRemoveAnyElement Not Found");
        return new ListElement("");
    }
}
