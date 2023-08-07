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
        QueueElement returnElement = queueStorage.remove(head);
        tail--;
        return returnElement;
    }
}
