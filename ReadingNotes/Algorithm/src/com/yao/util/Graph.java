package com.yao.util;

/**
 * Created by shanyao on 2018/7/19.
 * 使用邻接矩阵实现图

 */
public class Graph {
    private int[][] arcs;       //邻接矩阵
    private char[] vertices;   //各个点所携带的信息.

    private int vexnum;             //顶点的数目,
    // 记录节点是否已被遍历
    private boolean[] visited;

    private int[] visitedCount;         //记录访问

    private int[] currDist;             //最短路径算法中用来记录每个顶点距离起始顶点路径的长度.

    private String[] path;

    public Graph(int[][] arcs, char[] vertices){
        if(arcs.length != arcs[0].length){
            throw new IllegalArgumentException("arcs is not a adjacency matrix!");
        }
        if(arcs.length != vertices.length ){
            throw new IllegalArgumentException ("Argument of 2 vertices's length is error!");
        }
        this.arcs = arcs;
        this.vertices = vertices;
        vexnum = arcs.length;
        visitedCount = new int[vexnum];
    }

    public Graph(int n) {
        vexnum = n;
        vertices = new char[n];
        arcs = new int[n][n];
        visited = new boolean[n];
        currDist = new int[n];
        path = new String[n];
        for (int i = 0; i < vexnum; i++) {
            for (int j = 0; j < vexnum; j++) {
                arcs[i][j] = Integer.MAX_VALUE;
            }
        }

    }

    public int[][] getArcs() {
        return arcs;
    }

    public void setArcs(int[][] arcs) {
        this.arcs = arcs;
    }

    public char[] getVertices() {
        return vertices;
    }

    public void setVertices(char[] vertices) {
        this.vertices = vertices;
    }

    public int getVexnum() {
        return vexnum;
    }

    public void setVexnum(int vexnum) {
        this.vexnum = vexnum;
    }

    public int[] getVisitedCount() {
        return visitedCount;
    }

    public void setVisitedCount(int[] visitedCount) {
        this.visitedCount = visitedCount;
    }

    public int[] getCurrDist() {
        return currDist;
    }

    public void setCurrDist(int[] currDist) {
        this.currDist = currDist;
    }

    public boolean[] getVisited() {
        return visited;
    }

    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    //添加邻接矩阵信息，
    public void addEdge(int i, int j, int weight) {
        if (i == j) return;
        arcs[i][j] = weight;
        arcs[j][i] = weight;
    }

    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        this.path = path;
    }
}
