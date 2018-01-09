package imocc.algorithm;

import java.util.Arrays;

/**
 * Created by ljj on 2018/1/7.
 */
public class MergeSort {
    private void merge(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);
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
            } else if(aux[i-l]< aux[j-l]) {// 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l];
                i++;
            }else { // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l];
                j++;
            }
        }
    }
}
