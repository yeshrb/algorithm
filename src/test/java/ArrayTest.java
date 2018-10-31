

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
    public void testAddLast() {
        Array arr = new Array();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, arr.data);
    }

}