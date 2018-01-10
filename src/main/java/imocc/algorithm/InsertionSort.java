package imocc.algorithm;

import java.net.Inet4Address;

/**
 * Created by ljj on 2018/1/10.
 */
public class InsertionSort {
    public static void sort(Comparable[] arr) {
        int r = arr.length;
        for (int i = 1; i < r; i++) {
            for (int j = i; j >= 1 && (arr[j].compareTo(arr[j - 1]) < 0); j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 2, 8, 6, 1, 5, 7, 4};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
