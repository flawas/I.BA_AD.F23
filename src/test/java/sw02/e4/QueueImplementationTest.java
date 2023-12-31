package sw02.e4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueImplementationTest {

    @Test
    void enqueueOne() {
        QueueImplementation queueImplementation = new QueueImplementation();
        queueImplementation.enqueue(new QueueElement('A'));
    }

    @Test
    void dequeueOne() {
        QueueImplementation queueImplementation = new QueueImplementation();
        queueImplementation.enqueue(new QueueElement('A'));
        assertEquals('A', queueImplementation.dequeue().getData());
    }

    @Test
    void enqueueFour() {
        QueueImplementation queueImplementation = new QueueImplementation();
        queueImplementation.enqueue(new QueueElement('A'));
        queueImplementation.enqueue(new QueueElement('B'));
        queueImplementation.enqueue(new QueueElement('C'));
        queueImplementation.enqueue(new QueueElement('D'));
    }

    @Test
    void dequeueFour() {
        QueueImplementation queueImplementation = new QueueImplementation();
        queueImplementation.enqueue(new QueueElement('A'));
        queueImplementation.enqueue(new QueueElement('B'));
        queueImplementation.enqueue(new QueueElement('C'));
        queueImplementation.enqueue(new QueueElement('D'));
        assertEquals('A', queueImplementation.dequeue().getData());
        assertEquals('B', queueImplementation.dequeue().getData());
        assertEquals('C', queueImplementation.dequeue().getData());
        assertEquals('D', queueImplementation.dequeue().getData());
    }

    @Test
    void dequeueSix() {
        QueueImplementation queueImplementation = new QueueImplementation();
        queueImplementation.enqueue(new QueueElement('A'));
        queueImplementation.enqueue(new QueueElement('B'));
        queueImplementation.enqueue(new QueueElement('C'));
        queueImplementation.enqueue(new QueueElement('D'));
        queueImplementation.enqueue(new QueueElement('E'));
        assertEquals('A', queueImplementation.dequeue().getData());
        queueImplementation.enqueue(new QueueElement('F'));
        assertEquals('B', queueImplementation.dequeue().getData());
        assertEquals('C', queueImplementation.dequeue().getData());
        assertEquals('D', queueImplementation.dequeue().getData());
    }

    @Test
    void getQueueSize() {
        QueueImplementation queueImplementation = new QueueImplementation();
        queueImplementation.enqueue(new QueueElement('A'));
        queueImplementation.enqueue(new QueueElement('B'));
        assertEquals(2, queueImplementation.getQueueSize());
    }

    @Test
    void testToString() {
        QueueImplementation queueImplementation = new QueueImplementation();
        queueImplementation.enqueue(new QueueElement('A'));
        queueImplementation.enqueue(new QueueElement('B'));
        queueImplementation.enqueue(new QueueElement('C'));
        queueImplementation.enqueue(new QueueElement('D'));
        queueImplementation.enqueue(new QueueElement('E'));
        assertEquals("QueueImplementation{queueStorage=A,B,C,D,E}", queueImplementation.toString());
    }

    @Test
    void testFull() {
        QueueImplementation queueImplementation = new QueueImplementation();
        assertTrue(queueImplementation.enqueue(new QueueElement('A')));
        assertTrue(queueImplementation.enqueue(new QueueElement('B')));
        assertTrue(queueImplementation.enqueue(new QueueElement('C')));
        assertTrue(queueImplementation.enqueue(new QueueElement('D')));
        assertTrue(queueImplementation.enqueue(new QueueElement('E')));
        assertFalse(queueImplementation.enqueue(new QueueElement('F')));
        assertFalse(queueImplementation.enqueue(new QueueElement('G')));
    }
}