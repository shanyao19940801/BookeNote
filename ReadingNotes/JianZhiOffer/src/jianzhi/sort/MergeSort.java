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
            mergeSort(arr, first, mid, temp);//左边归并排序，使得左子序列有序
            mergeSort(arr, mid + 1, last, temp);//右边归并排序，使得右子序列有序
            merge(arr,first,mid,last,temp);//将两个有序子数组合并操作
        }
    }
    ////将有序数组arr[]和b[]合并到temp[]中
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
        //将左边剩余元素填充进temp中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        //将右序列剩余元素填充进temp中
        while (j <= last) {
            temp[t++] = arr[j++];
        }
        //将temp中的元素全部拷贝到原数组中
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
