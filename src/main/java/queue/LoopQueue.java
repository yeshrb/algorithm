package queue;

import array.DynamicArray;

public class LoopQueue<E> implements Queue<E> {
    private int front;
    private int tail;
    private DynamicArray<E> array;

    public LoopQueue(int capacity) {
        array = new DynamicArray<E>(capacity);
        front = 0;
        tail = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
        tail ++;

    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("dequeue failed,queue is empty");
        E result =  array.get(front);
        front++;
        return result;
    }

    @Override
    public E getFront() {
        return array.get(front);
    }

    @Override
    public int getSize() {
        return tail - front;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }
}
