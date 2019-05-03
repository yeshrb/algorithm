package array;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class ArrayTest {
    public ArrayTest() {
    }

    @Test
    public void should_create_an_array_with_length() {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        assertEquals(arr.length, 20);
        System.out.println(arr[20]);
    }

    @Test
    public void should_create_an_array_with_inriail_values() {
        int[] scores = new int[]{100, 99, 66};
        assertEquals(scores[0], 100);
        assertEquals(scores[1], 99);
        assertEquals(scores[2], 66);
    }

    @Test
    public void should_return_value_of_index() {

    }


}
