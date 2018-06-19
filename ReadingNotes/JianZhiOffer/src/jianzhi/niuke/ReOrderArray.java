package jianzhi.niuke;

/**
 * Created by shanyao on 2018/6/19.
 */
public class ReOrderArray {
    public static void reOrderArray(int [] array) {
        int aa = 0;
        for(int i = 1;i<array.length;i++) {
            if((array[i]&1)==0) {
                int j = i-1;
                while(j>=0 && (array[j]&1)==1 ){
                    aa++;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    j--;
                }
            }
        }
        System.out.println(aa);
    }

    public static void reOrderArray1(int [] array) {
        int bb= 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length-2;j>i;j--) {
                if ((array[j]&1)==0 && (array[j+1]&1)==1) {
                    bb++;
                    System.out.println("aa");
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println("bb"+bb);
    }

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6,7};
        reOrderArray1(a);
        reOrderArray(a);
    }
}
