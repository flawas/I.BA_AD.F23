package sw02.e4;

/**
 * The QueueInterface defines the contract for a queue data structure.
 * It provides methods for adding elements to the rear of the queue (enqueue)
 * and removing elements from the front of the queue (dequeue).
 */
public interface QueueInterface {

    /**
     * Adds an element to the rear of the queue.
     *
     * @param queueElement The QueueElement to be added to the queue.
     */
    public void enqueue(QueueElement queueElement);

    /**
     * Removes and returns the element from the front of the queue.
     *
     * @return The QueueElement removed from the front of the queue.
     */
    public QueueElement dequeue();
}