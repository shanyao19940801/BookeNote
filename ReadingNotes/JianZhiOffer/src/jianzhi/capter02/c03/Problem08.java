package jianzhi.capter02.c03;

/**
 * Created by shanyao on 2018/6/18.
 */
public class Problem08 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0)
            return 0;
        return findMin2(0,array.length,array);


    }
    //循环
    public int findMin(int [] array){
        int first = 0;
        int last = array.length-1;

        while (first <= last) {
            int middle = (first + last)/2;
            if (array[first] < array[last])
                return array[first];
            else {
                if (array[first] == array[last] && array[first] == array[middle]) {
                    int min = array[first];
                    for (int i = first+1; i<=last;i++) {
                        min = array[i]<min ? array[i] : min;
                    }
                    return min;
                } else {
                    if (array[middle] >= array[first]) {
                        first = middle + 1;
                    } else {
                        last = middle;
                    }
                }
            }
        }
        return array[first];
    }


    public static void main(String[] args) {
        int[] array = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        Problem08 p = new Problem08();
        System.out.println(p.minNumberInRotateArray(array));
    }
    //递归
    public int findMin2(int first,int last,int [] array){
        if (first>= last)
            return array[first];
        int middle = (first+last)/2;
        if (array[first] == array[last] && array[first] == array[middle]) {
            int min = array[first];
            for (int i = first+1; i<=last;i++) {
                min = array[i]<min ? array[i] : min;
            }
            return min;
        }
        if (array[first]<array[last])
            return array[first];
        else {
            if (array[middle] >= array[first]) {
                return findMin2(middle+1,last,array);
            } else {
               return findMin2(first,middle-1,array);
            }
        }
    }
}
