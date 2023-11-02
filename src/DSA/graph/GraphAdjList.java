package DSA.graph;

/*
String[] vertex = {"V1", "V2", "V3", "V4", "V5", "V6"};
String[][] edges = {{"V1","V2"}, {"V1","V4"},{"V2","V3"}, {"V2","V6"}, {"V3","V5"}, {"V3","V6"}, {"V4","V3"}, {"V4","V5"}};
 */
public class GraphAdjList {
    public int numVertices;
    public Vertex[] adjList;  // array of Vertices
    
    public GraphAdjList(int[] vertices) {
        this.numVertices = vertices.length;
        adjList = new Vertex[numVertices];
        for (int i = 0; i < numVertices; i++ ) {  // initialize array of Vertices
            adjList[i] = new Vertex(vertices[i]);
        }
    }
    
    public void addEdge(int[] edge) {
        int from = edge[0];
        int to = edge[1];
        
        for (int i = 0; i < adjList.length; i++) {  // Find from-vertex, from array of Vertices.
            if (adjList[i].val == from) {           // If found,
                Vertex curr = adjList[i];           // Find end of its adjVertices.
                while (curr.adjVertex != null) {
                    curr = curr.adjVertex;
                }
                curr.adjVertex = new Vertex(to);    // Add to-vertex to the end.
            }
        }
    }
    
    public void addEdges(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            addEdge(edges[i]);
        }
    }
    
    public void printGraph() {
        for (int i = 0; i < adjList.length; i++) {
            Vertex curr = adjList[i];
            System.out.print("V" + curr.val + " has edges to: ");
            while (curr.adjVertex != null) {
                System.out.print(curr.adjVertex.val + " ");
                curr = curr.adjVertex;
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        GraphAdjList graph = new GraphAdjList(new int[] {1, 2, 3, 4, 5, 6});
        graph.printGraph();
        System.out.println();
        int[][] edges = new int[][] {{1, 2}, {1, 4}, {2, 3}, {2, 6}, {3, 5}, {3, 6}, {4, 3}, {4, 5}};
        graph.addEdges(edges);
        graph.printGraph();
    }
    
}

class Vertex {
    int val;
    Vertex adjVertex;
    
    Vertex (int val) {
        this.val = val;
    }
}
