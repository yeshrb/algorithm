package array;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;


public class MyArrayTest {

    private MyArray array;

    @Before
    public void setUp() {
        array = new MyArray(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
    }

    @Test
    public void getSize() {
        assertEquals(array.getSize(), 10);
    }

    @Test
    public void getCapacity() {
        assertEquals(array.getCapacity(), 20);
    }

    @Test
    public void isEmpty() {
        assertEquals(false, array.isEmpty());
        MyArray myArr = new MyArray();
        assertEquals(true, myArr.isEmpty());
    }

    @Test
    public void addLast() {
        assertEquals(10, array.getSize());
        array.addLast(11);
        assertEquals(11, array.getSize());
    }

    @Test
    public void addFirst() {
        array.addFirst(-1);
        System.out.println(array);
    }

    @Test
    public void addOn() {
        array.addOn(1, 100);
        System.out.println(array);

    }

    @Test
    public void find() {
        assertEquals(1, array.find(1));
        array.addLast(1000);
        assertEquals(array.getSize() - 1, array.find(1000));
    }

    @Test
    public void get() {
        assertEquals(1, array.get(1));
        array.addLast(1000);
        assertEquals(1000, array.get(array.getSize() - 1));
    }

    @Test
    public void remove() {
        assertEquals(10, array.getSize());
        array.remove(0);
        assertEquals(9, array.getSize());
    }

    @Test
    public void removeFirst() {
        assertEquals(10, array.getSize());
        array.removeFirst();
        assertEquals(9, array.getSize());
        assertEquals(1, array.get(0));
    }
    @Test
    public void removeLast() {
        assertEquals(10, array.getSize());
        array.removeLast();
        assertEquals(9, array.getSize());
        assertEquals(8, array.get(array.getSize() - 1));
    }

    @Test
    public void toStringTest() {
        String expected = "Array:size = 10, capacity = 20\n"
                + "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]";
        assertEquals(expected, array.toString());
    }
}