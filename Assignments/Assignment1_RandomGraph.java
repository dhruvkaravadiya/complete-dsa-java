package Assignments;

import java.util.*;

/**
 * ASSIGNMENT 1:
 * Generate a random weighted undirected graph of n vertices and d * n(n-1)/2 edges,
 * where 0 < d < 1.0 and weight of each edge is randomly assigned between 1..n.
 * Store generated graph as Adjacency Matrix and Adjacency List.
 */
public class Assignment1_RandomGraph {

    // Representation of a neighboring node in the adjacency list
    public static class EdgeNode {
        int neighbor;
        int weight;

        public EdgeNode(int neighbor, int weight) {
            this.neighbor = neighbor;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + neighbor + ", weight=" + weight + ")";
        }
    }

    // Edge helper class for holding generated edges
    public static class Edge {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    private int numVertices;
    private int numEdges;
    private double density;
    private int[][] adjMatrix;
    private List<List<EdgeNode>> adjList;
    private List<Edge> edgesList;

    public Assignment1_RandomGraph(int n, double d) {
        if (n <= 1) {
            throw new IllegalArgumentException("Number of vertices n must be greater than 1.");
        }
        if (d <= 0.0 || d >= 1.0) {
            throw new IllegalArgumentException("Density d must satisfy 0 < d < 1.0.");
        }

        this.numVertices = n;
        this.density = d;
        
        // Total possible edges in a simple undirected graph: n * (n - 1) / 2
        long maxPossibleEdges = (long) n * (n - 1) / 2;
        this.numEdges = (int) Math.round(d * maxPossibleEdges);

        // Ensure at least 1 edge if density > 0 and maxPossibleEdges >= 1
        if (this.numEdges == 0 && maxPossibleEdges > 0) {
            this.numEdges = 1;
        }

        this.adjMatrix = new int[n][n];
        this.adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            this.adjList.add(new ArrayList<>());
        }
        this.edgesList = new ArrayList<>();

        generateRandomGraph();
    }

    private void generateRandomGraph() {
        Random random = new Random();

        // 1. Generate all possible unique pairs (u, v) with u < v (no self-loops)
        List<int[]> allPossibleEdges = new ArrayList<>();
        for (int u = 0; u < numVertices; u++) {
            for (int v = u + 1; v < numVertices; v++) {
                allPossibleEdges.add(new int[]{u, v});
            }
        }

        // 2. Shuffle pairs to pick 'numEdges' randomly without duplicates
        Collections.shuffle(allPossibleEdges, random);

        // 3. Pick the first 'numEdges' pairs and assign random weight in [1..n]
        for (int i = 0; i < numEdges && i < allPossibleEdges.size(); i++) {
            int[] pair = allPossibleEdges.get(i);
            int u = pair[0];
            int v = pair[1];
            
            // Random weight between 1 and n (inclusive)
            int weight = random.nextInt(numVertices) + 1;

            edgesList.add(new Edge(u, v, weight));

            // Populate Adjacency Matrix (Undirected graph is symmetric)
            adjMatrix[u][v] = weight;
            adjMatrix[v][u] = weight;

            // Populate Adjacency List
            adjList.get(u).add(new EdgeNode(v, weight));
            adjList.get(v).add(new EdgeNode(u, weight));
        }

        // Sort adjacency lists for neat display
        for (int i = 0; i < numVertices; i++) {
            adjList.get(i).sort(Comparator.comparingInt(e -> e.neighbor));
        }
    }

    public void displayGraphDetails() {
        long maxEdges = (long) numVertices * (numVertices - 1) / 2;
        System.out.println("=================================================");
        System.out.println("           GRAPH GENERATION SUMMARY              ");
        System.out.println("=================================================");
        System.out.println("Number of Vertices (n)     : " + numVertices);
        System.out.println("Density Factor (d)         : " + density);
        System.out.println("Max Possible Edges n(n-1)/2: " + maxEdges);
        System.out.println("Calculated Edges d*n(n-1)/2: " + numEdges);
        System.out.println("Weight Range               : [1, " + numVertices + "]");
        System.out.println("-------------------------------------------------");
        System.out.println("Generated Edges (" + edgesList.size() + "):");
        for (Edge e : edgesList) {
            System.out.println("  Vertex " + e.u + " <---> Vertex " + e.v + "  [Weight = " + e.weight + "]");
        }
        System.out.println("=================================================\n");
    }

    public void printAdjacencyMatrix() {
        System.out.println("-------------------------------------------------");
        System.out.println("        ADJACENCY MATRIX (0 = No Edge)           ");
        System.out.println("-------------------------------------------------");
        
        // Header row
        System.out.print("      ");
        for (int j = 0; j < numVertices; j++) {
            System.out.printf("V%-4d", j);
        }
        System.out.println("\n      " + "----".repeat(numVertices));

        // Matrix rows
        for (int i = 0; i < numVertices; i++) {
            System.out.printf("V%-4d|", i);
            for (int j = 0; j < numVertices; j++) {
                System.out.printf("%5d", adjMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printAdjacencyList() {
        System.out.println("-------------------------------------------------");
        System.out.println("                 ADJACENCY LIST                  ");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + " -> ");
            List<EdgeNode> neighbors = adjList.get(i);
            if (neighbors.isEmpty()) {
                System.out.println("[No outgoing edges / Isolated]");
            } else {
                for (int j = 0; j < neighbors.size(); j++) {
                    System.out.print(neighbors.get(j));
                    if (j < neighbors.size() - 1) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }
        }
        System.out.println("=================================================\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================================");
        System.out.println(" ASSIGNMENT 1: RANDOM WEIGHTED GRAPH GENERATION ");
        System.out.println("=================================================");

        int n;
        double d;

        while (true) {
            System.out.print("Enter number of vertices (n > 1): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 1) break;
                System.out.println("Invalid input! n must be > 1.");
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Enter density factor d (0 < d < 1.0, e.g. 0.4): ");
            if (scanner.hasNextDouble()) {
                d = scanner.nextDouble();
                if (d > 0.0 && d < 1.0) break;
                System.out.println("Invalid input! d must be strictly between 0.0 and 1.0.");
            } else {
                System.out.println("Invalid input! Please enter a floating point value.");
                scanner.next();
            }
        }

        System.out.println("\nGenerating Graph...\n");
        Assignment1_RandomGraph graph = new Assignment1_RandomGraph(n, d);
        graph.displayGraphDetails();
        graph.printAdjacencyMatrix();
        graph.printAdjacencyList();

        scanner.close();
    }
}
