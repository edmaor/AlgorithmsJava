package edu.maor.graphs;

import java.util.LinkedList;
public class Graph {
    public static class Edge {
        int origin, destination, cost;
        public Edge (int origin, int destination, int cost){
            this.origin = origin;
            this.destination = destination;
            this.cost = cost;
        }
    }
    protected int nodes;
    protected LinkedList<Edge>[] adjacencyList;

    public Graph(int nodes){
        this.nodes = nodes;
        adjacencyList = new LinkedList[nodes];
        for (int i=0; i < nodes; i++) adjacencyList[i] = new LinkedList<>();
    }
    public void addEdge(int origin, int destination){
        adjacencyList[origin].add(new Edge(origin, destination, 0));
    }
    public void addEdge(int origin, int destination, int cost){
        adjacencyList[origin].add(new Edge(origin, destination, cost));
    }
    public void removeEdge(int origin, int destination){
        Edge edge = null;
        for (Edge tempEdge : adjacencyList[origin]){
            if (tempEdge.destination == destination){
                edge = tempEdge;
                break;
            }
        }
        adjacencyList[origin].remove(edge);
    }
}