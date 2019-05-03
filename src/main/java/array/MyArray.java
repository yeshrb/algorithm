package array;

public class MyArray {
    private int[] data;
    private int size;

    public MyArray(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    public MyArray() {
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

    public void addLast(int element) {
        addOn(size, element);
    }

    public void addFirst(int element) {
        addOn(0, element);
    }


    public void addOn(int index, int element) {
        if (isArrayFull()) {
            throw new IllegalArgumentException("add failed, the Array is fulled!");
        }
        if (isOutOfBounds(index)) {
            throw new IllegalArgumentException("add failed, The index is out of array bounds");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;

    }


    public int get(int index) {
        if (isOutOfBounds(index)) {
            throw new IllegalArgumentException("add failed, The index is out of array bounds");
        }
        return data[index];
    }

    public void set(int index, int element) {
        if (isOutOfBounds(index)) {
            throw new IllegalArgumentException("add failed, The index is out of array bounds");
        }
        data[index] = element;
    }

    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element)
                return true;
        }
        return false;
    }

    public int find(int element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element)
                return i;
        }
        return -1;
    }

    public int remove(int index) {
        if (isOutOfBounds(index)) {
            throw new IllegalArgumentException("add failed, The index is out of array bounds");
        }
        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public void removeElement(int elements) {
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


}
