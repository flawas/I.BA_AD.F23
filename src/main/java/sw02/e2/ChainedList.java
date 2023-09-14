package sw02.e2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The ChainedList class represents a singly linked list that stores ListElement objects.
 * It allows adding, removing, and searching elements in the list.
 */
public class ChainedList {

    /**
     * Represents the head (first element) of the linked list.
     */
    private ListElement head;

    /**
     * Keeps track of the number of elements in the linked list.
     */
    private int sizeCounter;

    /**
     * Logger for logging debug information.
     */
    private static final Logger Log = LogManager.getLogger();

    /**
     * Adds a new element with the given data to the end of the linked list.
     *
     * @param data The data to be stored in the new element.
     */
    public void newElement(final String data) {

        // If head is null, set head with a new element
        if(this.head == null) {
            this.head = new ListElement(data);
        } else {
            // Find the last element and add the new element after it
            ListElement element = this.head;
            while(element.getNextElement() != null) {
                element = element.getNextElement();
            }
            element.setNextElement(new ListElement(data));
        }
    }

    /**
     * Returns the number of elements in the linked list.
     *
     * @return The size of the linked list.
     */
    public int getListSize() {
        sizeCounter = 0;
        ListElement element = this.head;

        if(element != null) {
            // Count the number of elements in the list
            sizeCounter++;
        }
        while(element.getNextElement() != null) {
            sizeCounter++;
            element = element.getNextElement();
        }
        return sizeCounter;
    }

    /**
     * Adds a new element with the given data to the beginning of the linked list.
     *
     * @param data The data to be stored in the new element.
     */
    public void newFirstElement(final String data) {
        ListElement oldHead = this.head;
        this.head = new ListElement(data);
        this.head.setNextElement(oldHead);
    }

    /**
     * Returns the head (first element) of the linked list.
     *
     * @return The head element of the linked list.
     */
    public ListElement getHead() {
        return this.head;
    }

    /**
     * Searches for a given ListElement in the linked list.
     *
     * @param listElement The element to search for.
     * @return true if the element is found, false otherwise.
     */
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

    /**
     * Removes and returns the first element from the linked list.
     *
     * @return The removed first element.
     */
    public ListElement getAndRemoveFirstElement() {
        ListElement newHead = this.head.getNextElement();
        ListElement oldHead = this.head;
        this.head = newHead;
        return oldHead;
    }

    /**
     * Removes and returns a specified element from the linked list.
     *
     * @param listElement The element to be removed.
     * @return The removed element, or an empty element if the specified element is not found.
     */
    public ListElement getAndRemoveAnyElement(final ListElement listElement) {
        // Check if the element exists in the list
        if(searchElement(listElement) == true) {

            // If the element is the first element
            if(this.head.equals(listElement)) {
                Log.debug("getAndRemoveAnyElement First");
                return this.getAndRemoveFirstElement();
            }

            // Find the element before the element to be removed
            ListElement element = this.head;
            while(!element.getNextElement().equals(listElement)) {
                element = element.getNextElement();
            }

            // If the element is in the middle of the list
            if(element.getNextElement().equals(listElement) && element.getNextElement().getNextElement() != null) {
                Log.debug("getAndRemoveAnyElement Middle");
                ListElement followingElement = element.getNextElement().getNextElement();
                ListElement returnElement = element.getNextElement();
                element.setNextElement(followingElement);
                return returnElement;
            }

            // If the element is at the end of the list
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
