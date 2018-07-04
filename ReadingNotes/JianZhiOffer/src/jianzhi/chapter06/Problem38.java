package jianzhi.chapter06;

/**
 * Created by shanyao on 2018/7/4.
 */
public class Problem38 {
    public int GetNumberOfK(int [] array , int k) {
        if(array.length == 0)
            return 0;

        return findByMid(array,k, 0, array.length-1);
    }

    public int findByMid(int [] array, int k,int first,int last) {
        int sum = 0;
        int l = 0;
        int r = 0;
        if(first < last) {

            int mid = (first+last) >> 1;
            if(array[mid] > k) {
                l = findByMid(array,k,first,mid);
            } else if(array[mid] < k) {
                r = findByMid(array,k,mid+1,last);
            } else {
                int mid1 = mid;
                while(mid <= last && array[mid] == k) {
                    mid++;
                }
                while(mid1 >= first && array[mid1] == k) {
                    mid1--;
                }
                sum = mid - mid1 - 1;

            }
        }
        return sum + l + r;
    }

    public static void main(String[] args) {
        Problem38 p = new Problem38();
        int [] a = {3};
        int sum = p.GetNumberOfK(a,3);
        System.out.println(sum);
    }
}
