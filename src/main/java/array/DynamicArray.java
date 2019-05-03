package array;

public class DynamicArray<E> {
    private E[] data;
    private int size;

    public DynamicArray(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public DynamicArray() {
        this(10);
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.data.length;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public void addLast(E element) {
        add(size, element);
    }

    public void addFirst(E element) {
        add(0, element);
    }


    public void add(int index, E element) {
        if (isOutOfBounds(index)) {
            throw new IllegalArgumentException("add failed, The index is out of array bounds");
        }
        if (isArrayFull()) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;

    }




    public E get(int index) {
        if (isOutOfBounds(index)) {
            throw new IllegalArgumentException("add failed, The index is out of array bounds");
        }
        return data[index];
    }

    public void set(int index, E element) {
        if (isOutOfBounds(index)) {
            throw new IllegalArgumentException("add failed, The index is out of array bounds");
        }
        data[index] = element;
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element))
                return true;
        }
        return false;
    }

    public int find(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element))
                return i;
        }
        return -1;
    }

    public E remove(int index) {
        if (isOutOfBounds(index)) {
            throw new IllegalArgumentException("add failed, The index is out of array bounds");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        if(size == data.length /2) {
            resize(data.length / 2);
        }

        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E elements) {
        int index = find(elements);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Array:size = %d, capacity = %d\n", size, data.length));
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i != size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }



    private boolean isArrayFull() {
        return size == data.length;
    }

    private boolean isOutOfBounds(int index) {
        return (index < 0 || index > size);
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
