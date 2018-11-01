

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ljj on 2018/1/10.
 */
public class ArrayTest {

    @Test
    public void testCreate() {
        Array arr = new Array();
        assertNotNull(arr);
        Array arr1 = new Array(20);
        assertNotNull(arr1);
    }

    @Test
    public void testGetSize() {
        Array arr = new Array(20);
        assertEquals(0, arr.getSize());
        arr = initTestArray(20);
        assertEquals(10, arr.getSize());

    }

    @Test
    public void testAddLast() {
        Array arr = initTestArray(10);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, arr.data);
    }

    @Test
    public void testAdd() {
        Array arr = initTestArray(20);
        arr.add(3, 100);
        assertArrayEquals(new int[]{0, 1, 2, 100, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0}, arr.data);

    }

    @Test
    public void testGetCapacity() {
        Array arr = initTestArray(10);
        assertEquals(10, arr.getCapacity());
        assertEquals(10, arr.getSize());
        Array arr1 = initTestArray(20);
        assertEquals(20, arr1.getCapacity());
        assertEquals(10, arr1.getSize());
    }

    @Test
    public void testAddFirst() {
        Array arr = new Array();
        arr.addFirst(100);
        assertEquals(100, arr.data[0]);
        arr.addFirst(200);
        assertEquals(200, arr.data[0]);

    }

    @Test
    public void testIsEmpty() {
        Array arr = new Array();
        assertTrue(arr.isEmpty());
        arr.addLast(1);
        assertFalse(arr.isEmpty());

    }

    @Test
    public void testToString() {
        Array arr = initTestArray(10);
        String expected = "Arrat: size = 10, capacity = 20\n"
                + "[0,1,2,3,4,5,6,7,8,9]";
        assertEquals(expected,arr.toString());

    }

    private Array initTestArray(int capacity) {
        Array arr = new Array(capacity);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        return arr;
    }
}