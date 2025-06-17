import java.util.*;

public class Graph {
    private int vertices;  // Number of vertices
    private LinkedList<Integer>[] adjacencyList;

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph (directed)
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    // Print the adjacency list representation of the graph
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer node : adjacencyList[i]) {
                System.out.print(" -> " + node);
            }
            System.out.println();
        }
    }

    // Example usage
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();
    }
}
