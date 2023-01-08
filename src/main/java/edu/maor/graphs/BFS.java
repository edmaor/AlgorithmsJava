package edu.maor.graphs;

import java.util.LinkedList;

public class BFS {
    public void bfs(Graph graph, int startingNode){
        boolean[] visited = new boolean[graph.nodes];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[startingNode] = true;
        queue.add(startingNode);

        while (queue.size() != 0){
            startingNode = queue.poll();
            System.out.printf("%d ", startingNode);
            for (Graph.Edge ge : graph.adjacencyList[startingNode]){
                if (!visited[ge.destination]){
                    visited[ge.destination] = true;
                    queue.add(ge.destination);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,5);
        graph.addEdge(0,7);
        graph.addEdge(1,3);
        graph.addEdge(3,2);
        graph.addEdge(3,5);
        graph.addEdge(3,6);
        graph.addEdge(5,1);
        graph.addEdge(6,5);
        graph.addEdge(7,0);
        BFS bfs = new BFS();
        bfs.bfs(graph,6);
    }
}
