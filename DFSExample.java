import java.util.*;

public class DFSExample {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    // Constructor
    public DFSExample(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add edge (directed)
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    // DFS traversal from given start vertex
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS traversal starting from vertex " + startVertex + ": ");
        dfsUtil(startVertex, visited);
        System.out.println();
    }

    // Helper method for DFS (recursive)
    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // Main method to test DFS
    public static void main(String[] args) {
        DFSExample graph = new DFSExample(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        graph.dfs(0);
    }
}
