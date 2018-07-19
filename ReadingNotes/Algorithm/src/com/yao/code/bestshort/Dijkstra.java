package com.yao.code.bestshort;

import com.yao.util.Graph;

import java.util.LinkedList;

/**
 * Created by shanyao on 2018/7/19.
 */
public class Dijkstra {
    LinkedList<Integer> list = new LinkedList();

    //初始化未访问节点
    private void initUnVisited(Graph g){
        for (int i = 0; i < g.getVexnum(); i++) {
            list.add(i);
            g.getCurrDist()[i] = Integer.MAX_VALUE;
        }
    }
    //初始化各个节点到初始节点的最短距离为最大长度
    private void initCurrDist(Graph g) {
        for (int i = 0; i < g.getVexnum(); i++) {
            g.getCurrDist()[i] = Integer.MAX_VALUE;
        }
    }

    /**
     *
     * @param first 初始节点的
     * @param g      图的邻接矩阵
     */
    private void dijkstraAlgorithm(int first, Graph g) {
        if (first < 0 || first > g.getVexnum()) {
            return;
        }
        //设置开始节点到本身路劲为0
        g.getCurrDist()[first] = 0;
        //获取下面将要访问的节点
        int curIndex = findMinWeight(g);

        //当所有的节点都被访问过后终止循环
        while (!list.isEmpty()) {
            //查看所有nextIndex节点相邻节点
            //遍历所有与顶点nowVertice相邻的顶点nextVertice.如果发现选择nowVertice到达nextVertice的路径后,nextVertice距离起始顶点的距离比当前的距离小.便更新新的距离.如下
            for (int j = 0; j < g.getVexnum(); j++) {
                int weight = g.getArcs()[curIndex][j];//当前节点到相邻节点权值
                int nextDist = g.getCurrDist()[j];//相邻接点到初始节点的路径
                int currDist = g.getCurrDist()[curIndex];
                if (weight != Integer.MAX_VALUE) {
                    //nextVertice距离起始顶点的距离比当前的距离小.便更新新的距离
                    if (nextDist > currDist + weight) {
                        g.getCurrDist()[j] = currDist + weight;
                    }
                }
            }
            curIndex = findMinWeight(g);
        }

    }

    //找出还为本访问节点中距离厨师节点路劲最短的节点并删除,并这个就是下面要访问的节点
    private int findMinWeight(Graph g){
        int index = list.get(0);
        int min = g.getCurrDist()[list.get(0)];
        int j = 0;
        for (int i = 1; i < list.size(); i++) {
            if (min > g.getCurrDist()[list.get(i)]) {
                index = list.get(i);
                j = i;
                min = g.getCurrDist()[list.get(i)];
            }
        }
        list.remove(j);
        return index;
    }

    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        Graph g = new Graph(9);
        char[] vertices = {'A','B','C','D','E','F','G','H','I'};
        g.setVertices(vertices);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 5, 1);
        g.addEdge(1, 0, 1);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 6, 1);
        g.addEdge(1, 8, 1);
        g.addEdge(2, 1, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(2, 8, 1);
        g.addEdge(3, 2, 1);
        g.addEdge(3, 4, 1);
        g.addEdge(3, 6, 1);
        g.addEdge(3, 7, 1);
        g.addEdge(3, 8, 1);
        g.addEdge(4, 3, 1);
        g.addEdge(4, 5, 1);
        g.addEdge(4, 7, 1);
        g.addEdge(5, 0, 1);
        g.addEdge(5, 4, 1);
        g.addEdge(5, 6, 1);
        g.addEdge(6, 1, 1);
        g.addEdge(6, 3, 1);
        g.addEdge(6, 5, 1);
        g.addEdge(6, 7, 1);
        g.addEdge(7, 3, 1);
        g.addEdge(7, 4, 1);
        g.addEdge(7, 6, 1);
        g.addEdge(8, 1, 1);
        g.addEdge(8, 2, 1);
        g.addEdge(8, 3, 1);

        d.initUnVisited(g);
        d.dijkstraAlgorithm(0,g);

        for (int i =0; i < g.getVexnum(); i++) {
            char a = (char) ('A' + i);
            System.out.println(a + ":" +g.getCurrDist()[i]);
        }

    }
}
