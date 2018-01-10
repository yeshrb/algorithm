package imocc.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ljj on 2018/1/10.
 */
public class SelectionSortTest {
    @Test
    public void testSort() throws Exception {
        int N = 100;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N-1);
        SortTestHelper.testSort("imocc.algorithm.SelectionSort",arr);
        assertTrue(SortTestHelper.isSorted(arr));
    }

}