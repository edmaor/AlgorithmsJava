package edu.maor.graphs;

public class DFS {
    public void dfsUtil(Graph graph, int node, boolean[] visited){
        visited[node] = true;
        System.out.printf("%d ", node);

        for (Graph.Edge ge: graph.adjacencyList[node]){
            if (!visited[ge.destination])
                dfsUtil(graph, ge.destination, visited);

        }
    }
    public void dfs(Graph graph, int startingNode){
        boolean[] visited = new boolean[graph.nodes];
        dfsUtil(graph, startingNode, visited);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1,15);
        graph.addEdge(0,5,40);
        graph.addEdge(0,7,10);
        graph.addEdge(1,3,25);
        graph.addEdge(3,2,10);
        graph.addEdge(3,5,25);
        graph.addEdge(3,6,30);
        graph.addEdge(5,1,35);
        graph.addEdge(6,5,10);
        graph.addEdge(7,0,10);

        DFS dfs = new DFS();
        dfs.dfs(graph, 0);
    }
}
