package DSA.graph;

import java.util.ArrayList;

/*
String[] vertex = {"V1", "V2", "V3", "V4", "V5", "V6"};
String[][] edges = {{"V1","V2"}, {"V1","V4"},{"V2","V3"}, {"V2","V6"}, {"V3","V5"}, {"V3","V6"}, {"V4","V3"}, {"V4","V5"}};
*/

// Input as Strings instead of int
// Print as v1->v2,v3
public class GraphAdjMatrix2 {
    
    public ArrayList<String> vertexNames = new ArrayList<>();
    public int numVertices;
    public int[][] adjMatrix;
    
    public GraphAdjMatrix2(String[] vertices) {
        this.numVertices = vertices.length;
        adjMatrix = new int[numVertices][numVertices];  // initialize matrix
        
        for (int i = 0; i < numVertices; i++) {  // copy array to save vertex names
            vertexNames.add(vertices[i]);
        }
    }
    
    public void markEdge(String from, String to) {
        int fromIdx = vertexNames.indexOf(from);
        int toIdx = vertexNames.indexOf(to);
        
        adjMatrix[fromIdx][toIdx] = 1;
    }
    
    public void markEdges(String[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            markEdge(edges[i][0], edges[i][1]);
        }
    }
    
    public void printMatrix() {
        System.out.print("  ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertexNames.get(i) + " ");  // print vNames on top (for column)
        }
        System.out.println();
        
        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertexNames.get(i) + " ");  // print vName for row
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + "  ");  // print matrix
            }
            System.out.println();
        }
    }
    
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertexNames.get(i) + "->");
            boolean putCommna = false;
            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j] == 1) {
                    if (putCommna) {
                        System.out.print("," + vertexNames.get(j));  // if second+ edge
                    }
                    else {
                        System.out.print(vertexNames.get(j));  // if first edge
                        putCommna = true;
                    }
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        String[] vertices = new String[] {"V7", "V2", "V3", "V9", "V5", "V6"};
        GraphAdjMatrix2 graph = new GraphAdjMatrix2(vertices);
        graph.printMatrix();
        System.out.println();
        String[][] edges = new String[][] {{"V7","V2"}, {"V7","V9"},{"V2","V3"}, {"V2","V6"}, {"V3","V5"}, {"V3","V6"}, {"V9","V3"}, {"V9","V5"}};
        graph.markEdges(edges);
        graph.printMatrix();
        System.out.println();
        graph.printGraph();
    }
    
}
