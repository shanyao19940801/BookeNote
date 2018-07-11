package jianzhi.sort;

/**
 * Created by shanyao on 2018/7/11.
 */
public class QuickSort {
    public static void main(String[] args) {
        int [] a = {3,2,4,1,6,5};
        quickSort(a,0,a.length - 1);
        System.out.println(a);
    }

    private static void quickSort(int [] a, int lo, int hi) {
        if (lo >= hi){
            return;
        }
        int j = partition(a,lo,hi);
        quickSort(a,lo,j-1);
        quickSort(a,j+1,hi);
    }
    //取数组第一个值v，
    private static int partition(int [] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        int v = a[lo];
        while (true) {
            while (a[++i] <= v) {
                if (i == hi)
                    break;;
            }
            while (a[--j] > v) {
                if (j == lo)
                    break;
            }
            if (i >= j) {
                break;
            }
            exch(a,i,j);

        }
        exch(a,lo,j);

        return j;
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
