package imocc.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
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
//    @Test
//    public void testSort() {
//        int[] a = {8,2,7,6,1,3,5,4};
//        MergeSort.sort(a);
//        int[] b = {1,2,3,4,5,6,7,8};
//        Assert.assertArrayEquals(b,a);
//    }
    @Test
    public void testmerge() throws Exception {

        Class<?> TargetClass = Class.forName("imocc.algorithm.MergeSort");
        Method  merge_method = TargetClass.getDeclaredMethod("merge",
                       new Class<?>[]{int[].class, int.class, int.class, int.class});
        merge_method.setAccessible(true);
        Object in = TargetClass.newInstance();
        int [] a = {2,4,6,8,1,3,5,7};
        Object[] paras = {a,0,3,7};
        int [] expected = {1,2,3,4,5,6,7,8};
        merge_method.invoke(in,paras);
        Assert.assertArrayEquals(expected,a);

    }

}