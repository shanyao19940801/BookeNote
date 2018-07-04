package jianzhi.chapter06;

/**
 * Created by shanyao on 2018/7/4.
 */
public class Problem38 {
    //方法二：
    /*public int GetNumberOfK1(int [] array , int k) {
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
    }*/

    public static void main(String[] args) {
        Problem38 p = new Problem38();
        /*int [] a = {3};
        int sum = p.GetNumberOfK(a,3);
        System.out.println(sum);*/

        int[] b = {1,3,3,3,3,4,5};
        int m = p.GetNumberOfK(b,2);
        System.out.println(m);
        /*int f = p.getFirstK(b,b.length,3,0,b.length - 1);
        System.out.println(f);
        int m = p.getLastK(b,b.length,3,0,b.length-1);
        System.out.println(m);*/
    }
    ////书中的算法
    public int GetNumberOfK(int [] array , int k) {
        int f = getFirstK(array,array.length,k,0,array.length - 1);
        int m = getLastK(array,array.length,k,0,array.length-1);
        if (f == -1 || m == -1) {
            return 0;
        }
        return m-f+1;
    }
    //找到第一个k的下标
    public int getFirstK(int [] array, int length, int k, int start, int end){
        if (start > end)
            return -1;
        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];
        if (middleData == k) {
            if ((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleData > k){
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getFirstK(array,length,k,start,end);
    }

    //找到最后一个k的下标
    public int getLastK(int [] array, int length, int k, int start, int end){
        if (start > end)
            return -1;
        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];
        if (middleData == k) {
            if ((middleIndex < length-1 && array[middleIndex + 1] != k) || middleIndex == length - 1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleData > k){
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getLastK(array,length,k,start,end);
    }


}
