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
        if(size == data.length) {
            throw new IllegalArgumentException("addLast failed,Array is full");
        }
        data[size] = e;
        size++;
    }
}
