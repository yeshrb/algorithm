package imocc.algorithm;

import java.util.Arrays;

/**
 * Created by ljj on 2018/1/7.
 */
public class MergeSort {
    public void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr,0,n-1);
    }
    public void sort(Comparable[] arr, int left, int right) {
        if(left>=right)
            return;
        int mid = (left+right)/2;
        sort(arr,left,mid);
        sort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }


    private void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) { // 如果左半部分元素已经全部处理完毕
            if(i > mid){
                arr[k] = aux[j-l];
                j++;
            }
            else if(j > r)  {// 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l];
                i++;
            } else if(aux[i-l].compareTo(aux[j-l])<0) {// 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l];
                i++;
            }else { // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l];
                j++;
            }
        }
    }
}
