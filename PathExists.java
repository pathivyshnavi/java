import java.util.*;

public class PathExists {

    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public PathExists(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    // Check if path exists from source to destination using DFS
    public boolean isPathExists(int source, int destination) {
        boolean[] visited = new boolean[vertices];
        return dfs(source, destination, visited);
    }

    private boolean dfs(int current, int destination, boolean[] visited) {
        if (current == destination) {
            return true;
        }

        visited[current] = true;

        for (int neighbor : adjacencyList[current]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, destination, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Test the implementation
    public static void main(String[] args) {
        PathExists graph = new PathExists(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        int source = 0;
        int destination = 5;

        if (graph.isPathExists(source, destination)) {
            System.out.println("Path exists from " + source + " to " + destination);
        } else {
            System.out.println("No path exists from " + source + " to " + destination);
        }
    }
}
