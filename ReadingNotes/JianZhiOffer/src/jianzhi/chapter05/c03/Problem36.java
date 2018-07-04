package jianzhi.chapter05.c03;

/**
 * Created by shanyao on 2018/7/4.
 */
public class Problem36 {
    int num = 0;
    public int InversePairs(int [] array) {
        if (array.length <= 1)
            return 0;
        int mid = array.length/2;
        mergeSort(array,0,array.length-1,new int[array.length]);
        return num%1000000007;
    }

    public void mergeSort(int [] array, int first,int last,int [] temp) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(array,first,mid,temp);
            mergeSort(array,mid+1,last,temp);
            //左右两边都已经排序，合并
            merge(array,first,mid,last,temp);
        }

    }

    private void merge(int[] array, int first, int mid, int last, int[] temp) {
        //int num = 0;
        int f= mid;
        int la = last;
        int t = last;
        while (f >= first && la >= mid + 1) {
            if (array[f] > array[la]) {
                num += la - mid;
                if(num > 1000000007) {
                    num %= 1000000007;
                }
                temp[t] = array[f];
                f--;
            } else {
                temp[t] = array[la];
                la--;
            }
            t--;
        }

        while (f >= first) {
            temp[t--] = array[f--];
        }
        while (la >= mid + 1) {
            temp[t--] = array[la--];
        }
        while (first <= last) {
            array[first] = temp[first];
            first++;
        }
        //turn num;
    }

    public static void main(String[] args) {
        Problem36 p = new Problem36();
        int [] a = {1,2,3,4,5,6,7,0};
        int sum = p.InversePairs(a);
        System.out.println(sum);
    }

}
