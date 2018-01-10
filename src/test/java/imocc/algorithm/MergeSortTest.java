package imocc.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static imocc.algorithm.SortTestHelper.isSorted;
import static org.junit.Assert.*;

/**
 * Created by lee on 2018/1/5.
 */
public class MergeSortTest {

    private Class<?> targetClass;
    private Integer[] testData;
    private static final int SCALE = 1000000;
    private Object instanceOfTargetClass;

    @Before
    public void setUp() throws Exception {
        targetClass = Class.forName("imocc.algorithm.MergeSort");
        testData = SortTestHelper.generateRandomArray(SCALE,0,1000000);
        instanceOfTargetClass = targetClass.newInstance();
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testSort() throws Exception{
        Method  sort_method = targetClass.getMethod("sort",
                new Class[]{Comparable[].class});
        long spanTime = evalMethodSpenTime(sort_method, testData);
        assertTrue(isSorted(testData));

    }
    @Test
    public void testSortIsONlgN() throws Exception {
        int scale_new = 100000;
        Integer[] data = SortTestHelper.generateRandomArray(scale_new,0,scale_new);
        Method  sort_method = targetClass.getMethod("sort",
                new Class[]{Comparable[].class});
        long spanTime_new = evalMethodSpenTime(sort_method,data);
        System.out.println(targetClass.getSimpleName() + ":" + spanTime_new);

        long spanTime = evalMethodSpenTime(sort_method, testData);
        System.out.println(targetClass.getSimpleName() + ":" + spanTime);
        System.out.println(spanTime*1.0/spanTime_new);
        double complexeScale = (Math.log(SCALE))/(Math.log(scale_new)) *(SCALE/scale_new);
        assertTrue((spanTime/spanTime_new) < complexeScale);

    }


    @Test
    public void testmerge() throws Exception {
        Method  merge_method = targetClass.getDeclaredMethod("merge",
                       new Class<?>[]{Comparable[].class, int.class, int.class, int.class});
        merge_method.setAccessible(true);
        Integer [] a = {2,4,6,8,1,3,5,7};
        Object[] paras = {a,0,3,7};
        Integer [] expected = {1,2,3,4,5,6,7,8};
        InvokeMethod(instanceOfTargetClass,merge_method, paras);
        Assert.assertArrayEquals(expected,a);

    }

    private long evalMethodSpenTime(Method sort_method, Object paras)
            throws IllegalAccessException, InvocationTargetException {
        long startTime = System.currentTimeMillis();
        Object[] params = new Object[]{paras};
        InvokeMethod(instanceOfTargetClass,sort_method, params);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private void InvokeMethod(Object instanceCalled,Method method, Object[] paras)
            throws IllegalAccessException, InvocationTargetException {

        method.invoke(instanceCalled,paras);
    }


}