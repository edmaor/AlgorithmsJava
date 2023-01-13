package edu.maor.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class ShortPath {
    public void heapifyEdges(ArrayList<Graph.Edge> edges, int len, int i) {
        int smallest = i;
        int lc = 2 * i + 1; // Get left child
        int rc = 2 * i + 2; // Get right child
        if (lc < len && edges.get(lc).cost < edges.get(smallest).cost) smallest = lc;
        if (rc < len && edges.get(rc).cost < edges.get(smallest).cost) smallest = rc;
        if (smallest != i) {
            Graph.Edge swap = edges.get(i);
            edges.set(i, edges.get(smallest));
            edges.set(smallest, swap);
            heapifyEdges(edges, len, smallest);
        }
    }

    public void dijkstra(Graph graph, int node) {
        boolean[] visited = new boolean[graph.nodes];
        int[] distances = new int[graph.nodes];

        visited[node] = true;
        ArrayList<Graph.Edge> queue = new ArrayList<>(graph.adjacencyList[node]);

        while (!queue.isEmpty()) {
            heapifyEdges(queue, queue.size(), node);
            // node = queue.remove(0).destination;
            Graph.Edge edge = queue.remove(0);
            if (distances[edge.origin] + edge.cost < distances[edge.destination] || !visited[edge.destination]) {
                distances[edge.destination] = distances[edge.origin] + edge.cost;
                visited[edge.destination] = true;
                queue.addAll(graph.adjacencyList[edge.destination]);
            }
//            for (Graph.Edge edge : graph.adjacencyList[node]) {
//                if (distances[node] + edge.cost < distances[edge.destination] || !visited[edge.destination]) {
//                    distances[edge.destination] = distances[node] + edge.cost;
//                    visited[edge.destination] = true;
//                    queue.add(edge);
//                }
//            }
        }
        for (int i = 0; i < graph.nodes; i++) {
            if (visited[i]) System.out.printf(" %d | %d\n", i, distances[i]);
            else System.out.printf(" %d | UNREACHABLE\n", i);
        }
    }

    public LinkedList<Graph.Edge> dijkstra(Graph graph, int origin, int destination) {
        boolean[] visited = new boolean[graph.nodes];
        int[] distances = new int[graph.nodes];
        int[] parents = new int[graph.nodes];
        LinkedList<Graph.Edge> shortestPath = new LinkedList<>();

        visited[origin] = true;
        ArrayList<Graph.Edge> queue = new ArrayList<>(graph.adjacencyList[origin]);

        while (!queue.isEmpty()) {
            heapifyEdges(queue, queue.size(), 0);
            Graph.Edge edge = queue.remove(0);
            if (!visited[edge.destination] || distances[edge.origin] + edge.cost < distances[edge.destination]) {
                visited[edge.destination] = true;
                distances[edge.destination] = distances[edge.origin] + edge.cost;
                parents[edge.destination] = edge.origin;

                if (edge.origin != destination) queue.addAll(graph.adjacencyList[edge.destination]);
            }
        }
        System.out.printf("%d", origin);
        if (visited[destination]) {
            int currentNode = destination;
            while (currentNode != origin) {
                shortestPath.addFirst(new Graph.Edge(parents[currentNode], currentNode, distances[currentNode] - distances[parents[currentNode]]));
                currentNode = parents[currentNode];
            }
            for (Graph.Edge edge : shortestPath) {
                System.out.printf(" --%d--> %d", edge.cost, edge.destination);
            }
            System.out.printf(" | COST: %d", distances[destination]);
            return shortestPath;
        } else {
            System.out.printf(" -- UNREACHABLE --> %d", destination);
            return null;
        }
    }

    public static void main(String[] args) {

        Graph graph = new Graph(8);
        graph.addEdge(0, 1, 15);
        graph.addEdge(0, 5, 40);
        graph.addEdge(0, 7, 10);
        graph.addEdge(1, 3, 25);
        graph.addEdge(3, 2, 10);
        graph.addEdge(3, 5, 25);
        graph.addEdge(3, 6, 30);
        graph.addEdge(5, 1, 35);
        graph.addEdge(6, 5, 10);
        graph.addEdge(7, 0, 10);

        ShortPath shortPath = new ShortPath();
        shortPath.dijkstra(graph, 0);
        System.out.println();
        shortPath.dijkstra(graph, 0, 4);
    }
}