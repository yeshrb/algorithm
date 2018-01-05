package imocc.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by lee on 2018/1/5.
 */
public class MergeSortTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testSort() {
        int[] a = {8,2,7,6,1,3,5,4};
        MergeSort.sort(a);
        int[] b = {1,2,3,4,5,6,7,8};
        Assert.assertArrayEquals(b,a);
    }

}