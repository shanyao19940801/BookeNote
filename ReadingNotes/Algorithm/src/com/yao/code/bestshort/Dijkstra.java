package com.yao.code.bestshort;

import com.yao.util.Graph;

/**
 * Created by shanyao on 2018/7/19.
 */
public class Dijkstra {

    public static void main(String[] args) {
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
    }
}
