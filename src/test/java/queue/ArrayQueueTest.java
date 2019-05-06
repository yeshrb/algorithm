package queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayQueueTest {

    ArrayQueue<Integer> queue;

    @Before
    public void setUp() throws Exception {
        queue = new ArrayQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
    }

    @Test
    public void enqueue() {
        assertEquals(10, queue.getSize());
    }

    @Test
    public void dequeue() {
        assertEquals(0, (int)queue.dequeue());
        assertEquals(1, (int)queue.dequeue());
        assertEquals(2, (int)queue.dequeue());
        assertEquals(3, (int)queue.dequeue());
    }

    @Test
    public void getFront() {
        assertEquals(0, (int)queue.getFront());
    }

    @Test
    public void getSize() {
        assertEquals(10,queue.getSize());
    }

    @Test
    public void isEmpty() {
        ArrayQueue<Integer> queue_1 = new ArrayQueue<Integer>();
        assertEquals(true,queue_1.isEmpty());
        queue_1.enqueue(100);
        assertEquals(false,queue_1.isEmpty());
    }
}