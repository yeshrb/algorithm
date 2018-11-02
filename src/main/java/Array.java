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

    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add failed,Array is full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed,idnex must be >=0 and <=size");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addLast(int e) {
        add(size, e);
    }

    public void addFirst(int e) {
        add(0, e);
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return data.length;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Arrat: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(i);
            if (i < size - 1)
                res.append(',');
        }
        res.append("]");
        return res.toString();
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed,index must >=0 and < size");
        }

        return data[index];
    }

    public void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed,index must >=0 and < size");
        }
        data[index] = e;
    }

    public int find(int e) {
        int res = -1;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] == e) {
                res = i;
                break;
            }
        }
        return res;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed,index must >=0 and < size");
        }
        int res = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return res;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public void removeElement(int e) {
        int index = find(e);
        if(index != -1)
            remove(index);

    }
}
