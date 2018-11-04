public class Array<E> {
    private int size;
    public E[] data;

    public Array(int capacity) {
        this.size = 0;
        data = (E[]) new Object[capacity];
    }

    public Array() {
        this(10);
    }

    public void add(int index, E e) {
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

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
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

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed,index must >=0 and < size");
        }

        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed,index must >=0 and < size");
        }
        data[index] = e;
    }

    public int find(E e) {
        int res = -1;
        for (int i = 0; i < size - 1; i++) {
            if (data[i].equals(e)) {
                res = i;
                break;
            }
        }
        return res;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed,index must >=0 and < size");
        }
        E res = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return res;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);

    }
}
