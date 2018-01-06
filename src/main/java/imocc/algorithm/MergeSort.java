package imocc.algorithm;

import java.util.*;

public class MergeSort {
    public static void sort(int[] a) {
        int n = a.length;
        mergeSort(a,0,n-1);
    }

    public static void mergeSort(int[] a, int l, int r) {
        int mid = (l+r)/2;
        mergeSort(a,l,mid);
        mergeSort(a,mid+1,r);
        merge(a,l,mid,r);
    }

    public static void merge(int[] a, int l, int mid, int r) {
        int i=l,j=mid + 1;
        int [] aux = Arrays.copyOfRange(a,l,r);
        for(int k = l; k <= r; k++){

            if(aux[i-l]<aux[j]) {
                a[k] = aux[i];
                i++;
            }
            else {
                a[k] = aux[j];
                j++;
            }
        }

    }

}
