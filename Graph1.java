public class Graph1 {
    private int vertices;        // Number of vertices
    private int[][] adjacencyMatrix;

    // Constructor
    public Graph1(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    // Add an edge to the graph (directed)
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
    }

    // Remove an edge from the graph
    public void removeEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 0;
    }

    // Check if there is an edge between two vertices
    public boolean hasEdge(int source, int destination) {
        return adjacencyMatrix[source][destination] == 1;
    }

    // Print the adjacency matrix
    public void printGraph1() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Example usage
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.printGraph();
    }
}
