package jianzhi.capter02.c03;

/**
 * Created by user on 2018/2/28.
 * 数组查找
 */
public class P231 {
    int[][] matrix = new int[][]{
            {1,2,8,9},
            {2,4,9,12},
            {4,7,10,13},
            {6,8,11,15}
    };

    public boolean find(int[][] matrix,int rows, int colums, int number) {
        boolean result = false;
        int tempRow = 0;
        int tempColum = colums - 1;
        if (matrix!=null && rows > 0 && colums > 0) {
            while (tempColum >= 0 && tempRow < rows) {
                if (matrix[tempRow][tempColum] == number) {
                    return true;
                }
                if (matrix[tempRow][tempColum] > number)
                    tempColum--;
                if (matrix[tempRow][tempColum] < number)
                    tempRow++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        P231 p231 = new P231();
        System.out.println(p231.find(p231.matrix, 4, 4, 6));
    }
}
