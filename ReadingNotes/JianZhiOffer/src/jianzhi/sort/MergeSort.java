package jianzhi.sort;

/**
 * Created by shanyao on 2018/7/3.
 */
public class MergeSort {
    public void sort(int [] arr) {
        int mid = arr.length/2;
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
    }
    public void mergeSort(int [] arr, int first, int last, int[] temp) {
        int mid = (first + last)/2;
        if (first < last) {
            mergeSort(arr, first, mid, temp);
            mergeSort(arr, mid + 1, last, temp);
            merge(arr,first,mid,last,temp);
        }
    }
    public void merge(int[] arr, int first, int mid, int last, int[] temp) {
        int i = first;
        int j = mid + 1;
        int t = i;
        while ( i <= mid && j <= last) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= last) {
            temp[t++] = arr[j++];
        }
        for (int m = first; m <= last; m++) {
            arr[m] = temp[m];
        }
    }

    public static void main(String[] args) {
        int [] a = {6,7,9,2,3};
        MergeSort m = new MergeSort();
        int mid = (0+4)/2;
        int [] temp = new int[5];
        m.sort(a);
        System.out.println(a);
    }
}
