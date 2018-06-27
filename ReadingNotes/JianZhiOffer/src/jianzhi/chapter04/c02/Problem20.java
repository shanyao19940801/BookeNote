package jianzhi.chapter04.c02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanyao on 2018/6/24.
 */
public class Problem20 {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList result = new ArrayList();
        //方法二：每一圈打印总是从左上角a[start][start]这个数字开始，每打印一圈start+1
        //观察可以得到，start*2必然小于数组的长度与宽度
        int start = 0;
        int x = matrix.length;
        int y = matrix[0].length;
        if(matrix==null|| y<=0 || x<=0) {
            return result;
        }
        while(start*2<x && start*2<y) {
            printCycle(matrix,start,x,y,result);
        }
        return result;

        //方法一：
        /*int [] start = {0,0};
        int [] end = {matrix[0].length-1,matrix.length-1};
        while(start[0]<=end[0] && start[1]<=end[1]){
            for(int i = start[0];i<=end[0];i++) {
                sout(i,start[1]);
                result.add1(matrix[start[1]][i]);
            }
            start[1]++;
            *//*if (!(start[0]<=end[0] && start[1]<=end[1])) {
                break;
            }*//*
            for(int i = start[1];i<=end[1];i++ ) {
                result.add1(matrix[i][end[0]]);
                sout(end[0],i);
            }
            end[0]--;
            *//*if (!(start[0]<=end[0] && start[1]<=end[1])) {
                break;
            }*//*
            for(int i = end[0];i>=start[0];i-- ) {
                result.add1(matrix[end[1]][i]);
                sout(i,end[1]);
            }
            end[1]--;
            for(int i = end[1];i>=start[1];i-- ) {
                result.add1(matrix[i][start[0]]);
                sout(start[0],i);
            }
            start[0]++;
        }
        return result;*/
    }

    public static void sout(int i,int j) {
        System.out.println("x="+i+"y="+j);
    }

    public static void printCycle(int[][] matrix,int start,int x,int y,ArrayList result) {
        int endX = x-start-1;
        int endY = y -start - 1;
        for(int i=start;i<=endY;i++){
            result.add(matrix[start][i]);
        }
        if(start<endX){
            for(int i = start+1;i<=endX;i++){
                result.add(matrix[i][endY]);
            }
        }
        if(start<endX && start<endY){
            for(int i = endY-1;i>=start;i--){
                result.add(matrix[endX][i]);
            }
        }
        if(endX-1>start&& start<endY) {
            for(int i = endX-1;i>=start+1;i--){
                result.add(matrix[i][start]);
            }
        }

    }

    public static void main(String[] args) {
        int [][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List l = printMatrix(a);
        System.out.println(l);
    }
}
