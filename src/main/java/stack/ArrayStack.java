package stack;

import array.DynamicArray;

public class ArrayStack<E> implements Stack<E> {
    DynamicArray<E> array;

    public ArrayStack(int capacity) {
        array = new DynamicArray(capacity);
    }

    public ArrayStack() {
        array = new DynamicArray();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }
    public void push(E e) {
        array.addLast(e);
    }

    public E pop() {
        return array.removeLast();
    }

    public E peek() {
        return array.getLast();
    }

}
