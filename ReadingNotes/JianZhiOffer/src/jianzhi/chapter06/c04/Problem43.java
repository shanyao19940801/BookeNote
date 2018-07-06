package jianzhi.chapter06.c04;

/**
 * Created by shanyao on 2018/7/6.
 */
public class Problem43 {
    void PrintProbability(int number, int count) {
        int max= number * count + 1;
        int [][] p1 = new int[2][];
        p1[0] = new int[max];
        p1[1] = new int[max];
        for (int i =0;i <= max; i++) {
            p1[0][i] = 0;
            p1[1][i] = 0;
        }

        int flag = 0;
        for (int i = 1; i <= number; i++){
            p1[flag][i] = 1;
        }

        int num1 = 1;
        for (int i = number + 1; i < max; i++) {
            for (int j = 1;j<=i;j++) {

            }

        }

    }
    public static void main(String[] args) {

    }
}
