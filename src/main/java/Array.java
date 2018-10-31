public class Array {
    private int size;
    public int[] data;

    public Array(int capacity) {
        this.size = 0;
        data = new int[capacity];
    }

    public Array() {
        this(10);
    }

    public void addLast(int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("addLast failed,Array is full");
        }
        data[size] = e;
        size++;
    }

    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add failed,Array is full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed,idnex must be >=0 and <=size");
        }
        for (int i = size - 1; i > index + 1; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public int getSize() {
        return this.size;
    }
}
