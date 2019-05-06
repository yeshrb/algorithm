package queue;

import array.DynamicArray;

public class ArrayQueue<E> implements Queue<E> {
    DynamicArray<E> array;

    public ArrayQueue(int capacity) {
        array = new DynamicArray<E>(capacity);
    }

    public ArrayQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
}
