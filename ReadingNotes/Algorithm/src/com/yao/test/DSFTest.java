package com.yao.test;

/**
 * Created by shanyao on 2018/7/18.
 */
public class DSFTest {
    public int [][] jz;
    public boolean[] visit;
    private char[] yuansu;
    private int vuenum;
    public DSFTest(int chushi) {
        jz = new int[chushi][chushi];
        visit = new boolean[chushi];
        yuansu = new char[chushi];
        vuenum = chushi;
    }

    public void setYuansu(char[] yuansu) {
        this.yuansu = yuansu;
    }

    //深度优先
    public void dsf(int i){
        if (visit[i] == false) {
            System.out.print(yuansu[i]+" ");
            visit[i] = true;
        }
        for (int j = 0; j < vuenum;j++) {
            if (jz[i][j] == 1 && visit[j] == false) {
                dsf(j);
            }
        }
    }

    public void DFSTraverse(){
        for (int i = 0; i < vuenum;i++) {
            visit[i] = false;
        }

        for (int i = 0; i < vuenum; i++) {
            if (visit[i] == false) {
                dsf(i);
            }
        }
    }

    public void addEdge(int i, int j){
        if (i==j)
            return;
        jz[i][j] = 1;
        jz[j][i] = 1;
    }

    public static void main(String[] args) {
        DSFTest g = new DSFTest(9);
        char[] vertices = {'A','B','C','D','E','F','G','H','I'};
        g.setYuansu(vertices);

        g.addEdge(0, 1);
        g.addEdge(0, 5);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(1, 6);
        g.addEdge(1, 8);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 8);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        g.addEdge(3, 8);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 7);
        g.addEdge(5, 0);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 1);
        g.addEdge(6, 3);
        g.addEdge(6, 5);
        g.addEdge(6, 7);
        g.addEdge(7, 3);
        g.addEdge(7, 4);
        g.addEdge(7, 6);
        g.addEdge(8, 1);
        g.addEdge(8, 2);
        g.addEdge(8, 3);

        System.out.print("深度优先遍历（递归）：");
        g.DFSTraverse();

        System.out.println();

        System.out.print("深度优先遍历（非递归）：");
//        g.DFSTraverse2();
    }

}
