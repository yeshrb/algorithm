package imocc.algorithm;
/*
* 选择排序，每次选出最小的那个
*
* */

public class SelectionSort {
    public static void sort(Comparable[] arr){
        int r = arr.length -1;
        for(int i = 0;i<=r;i++) {
            for(int j=i+1; j<=r;j++) {
                if(arr[j].compareTo(arr[i]) < 0) {
                    swap(arr,i,j);
                }
            }
        }

    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
