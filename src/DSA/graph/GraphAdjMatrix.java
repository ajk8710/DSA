package DSA.graph;

/*
String[] vertex = {"V1", "V2", "V3", "V4", "V5", "V6"};
String[][] edges = {{"V1","V2"}, {"V1","V4"},{"V2","V3"}, {"V2","V6"}, {"V3","V5"}, {"V3","V6"}, {"V4","V3"}, {"V4","V5"}};
 */
public class GraphAdjMatrix {
    
    public int numVertices;
    public int[][] adjMatrix;
    
    public GraphAdjMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }
    
    public void markEdge(int from, int to) {
        adjMatrix[from][to] = 1;
    }
    
    public void markEdges(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0] - 1;
            int to = edges[i][1] - 1;
            adjMatrix[from][to] = 1;
        }
    }
    
    public void printGraph() {
        System.out.print("  ");
        for (int i = 1; i <= numVertices; i++) {
            System.out.print("V" + i + " ");
        }
        System.out.println();
        
        for (int i = 0; i < numVertices; i++) {
            int vNum = i + 1;
            System.out.print("V" + vNum + " ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        GraphAdjMatrix graph = new GraphAdjMatrix(6);
        graph.printGraph();
        System.out.println();
        int[][] edges = new int[][] {{1, 2}, {1, 4}, {2, 3}, {2, 6}, {3, 5}, {3, 6}, {4, 3}, {4, 5}};
        graph.markEdges(edges);
        graph.printGraph();
    }
    
}
