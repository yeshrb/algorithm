

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ljj on 2018/1/10.
 */
public class ArrayTest {
    //    @Test
//    public void testToString()  {
//
//    }
    @Test
    public void testCreate() {
        Array arr = new Array();
        assertNotNull(arr);
        Array arr1 = new Array(20);
        assertNotNull(arr1);
    }
    @Test
    public void testGetSize(){
        Array arr = new Array(20);
        assertEquals(0,arr.getSize());
        arr = initTestArray(20);
        assertEquals(10,arr.getSize());

    }

    @Test
    public void testAddLast() {
        Array arr = initTestArray(10);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, arr.data);
    }

    @Test
    public void testAdd(){
        Array arr = initTestArray(20);
        arr.add(3,100);
        assertArrayEquals(new int[]{0, 1, 100,2, 3, 4, 5, 6, 7, 8, 9}, arr.data);


    }
    private Array initTestArray(int capacity) {
        Array arr = new Array(capacity);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        return arr;
    }
}