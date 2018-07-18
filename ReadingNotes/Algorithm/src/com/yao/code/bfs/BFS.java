package com.yao.code.bfs;

import java.util.LinkedList;

/**
 * Created by shanyao on 2018/7/18.
 */
public class BFS {

    // 存储节点信息
    private char[] vertices;

    // 存储边信息（邻接矩阵）
    private  int[][] arcs;

    // 图的节点数
    private int vexnum;

    // 记录节点是否已被遍历
    private boolean[] visited;

    LinkedList<Integer> list = new LinkedList<>();

    public BFS(int n) {
        vexnum = n;
        vertices = new char[n];
        arcs = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < vexnum; i++) {
            for (int j = 0; j < vexnum; j++) {
                arcs[i][j] = 0;
            }
        }
    }

    // 添加边(无向图)
    public void addEdge(int i, int j) {
        // 边的头尾不能为同一节点
        if (i == j)return;

        arcs[i][j] = 1;
        arcs[j][i] = 1;
    }

    // 设置节点集
    public void setVertices(char[] vertices) {
        this.vertices = vertices;
    }

    // 设置节点访问标记
    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }


    public static void main(String[] args) {
        BFS g = new BFS(9);
        char[] vertices = {'A','B','C','D','E','F','G','H','I'};
        g.setVertices(vertices);

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

        System.out.print("广度优先遍历：");
        g.BFSTraverse();

        System.out.println();

    }

    //广度优先遍历
    private void BFSTraverse() {
        for (int i = 0; i < vexnum;i++) {
            visited[i] = false;
        }

        list.add(0);
        traverse();
    }

    //广度优先遍历
    private void traverse() {
        while (!list.isEmpty()) {
            int i = list.pop();
            if (visited[i]) {
                continue;
            }
            System.out.print(vertices[i] + " ");
            visited[i] = true;
            for (int j = 0; j < vexnum; j++) {
                if (arcs[i][j] == 1) {
                    if (!visited[j]) {
                        list.add(j);
                    }
                }
            }
        }
    }

    //邻接矩阵如下
    /**
     *      A  B  C  D  E  F  G  H  I
     *   A     1           1
     *   B  1     1           1     1
     *   C     1     1              1
     *   D        1     1     1  1  1
     *   E           1     1  1
     *   F  1           1     1
     *   G     1     1     1     1
     *   H           1  1     1
     *   I     1  1  1
     *
     */

}
