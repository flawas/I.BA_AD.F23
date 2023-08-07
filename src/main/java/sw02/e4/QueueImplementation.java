package sw02.e4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * The QueueImplementation class represents a queue data structure and implements the QueueInterface.
 * It uses an ArrayList to store the queue elements and provides methods to enqueue elements to the rear of the queue
 * and dequeue elements from the front of the queue.
 */
public class QueueImplementation implements QueueInterface {

    /**
     * The capacity of the queue storage.
     */
    private static int QUEUESTORAGE_CAPACITY = 5;

    /**
     * The ArrayList used to store the queue elements.
     */
    private ArrayList<QueueElement> queueStorage = new ArrayList<>(QUEUESTORAGE_CAPACITY);

    /**
     * The index of the head of the queue.
     */
    private int head = 0;

    /**
     * The index of the tail of the queue.
     */
    private int tail = 0;

    /**
     * Logger for logging information and errors.
     */
    private static final Logger Log = LogManager.getLogger();

    /**
     * Constructs a new QueueImplementation with an empty queue.
     */
    public QueueImplementation() {
    }

    /**
     * Gets the current size of the queue.
     *
     * @return The number of elements in the queue.
     */
    public int getQueueSize() {
        return queueStorage.size();
    }

    /**
     * Adds an element to the rear of the queue.
     *
     * @param queueElement The QueueElement to be added to the queue.
     */
    @Override
    public void enqueue(QueueElement queueElement) {
        queueStorage.add(tail, queueElement);
        if (tail < QUEUESTORAGE_CAPACITY) {
            tail++;
        }
    }

    /**
     * Removes and returns the element from the front of the queue.
     *
     * @return The QueueElement removed from the front of the queue.
     */
    @Override
    public QueueElement dequeue() {
        if(!queueStorage.isEmpty()) {
            QueueElement returnElement = queueStorage.remove(head);
            tail--;
            return returnElement;
        }
        return new QueueElement('0');
    }

    /**
     * Retrieves the elements of the queue storage as a comma-separated string.
     * If the queue is not empty, it iterates through the elements in the queue and constructs a string
     * containing the data of each element, separated by commas.
     *
     * @return A string representation of the queue storage elements, separated by commas, or an empty string if the queue is empty.
     */
    public String getQueueStorageElements() {
        String returnString = "";
        if (!queueStorage.isEmpty()) {
            for (int i = 0; i < getQueueSize(); i++) {
                if (i == 0) {
                    returnString += queueStorage.get(i).getData();
                } else {
                    returnString += "," + queueStorage.get(i).getData();
                }
            }
            return returnString;
        }
        return "";
    }

    /**
     * Returns a string representation of the QueueImplementation object.
     * The string includes the queue storage elements in a formatted manner.
     *
     * @return A string representation of the QueueImplementation object, including the queue storage elements.
     */
    @Override
    public String toString() {
        return "QueueImplementation{" +
                "queueStorage=" + getQueueStorageElements() +
                '}';
    }

}
