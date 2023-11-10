package DSA.graph;

import java.util.HashMap;

/*
String[] vertex = {"V1", "V2", "V3", "V4", "V5", "V6"};
String[][] edges = {{"V1","V2"}, {"V1","V4"},{"V2","V3"}, {"V2","V6"}, {"V3","V5"}, {"V3","V6"}, {"V4","V3"}, {"V4","V5"}};
*/

// Input as Strings instead of int
// Print as v1->v2,v3
public class GraphAdjList2 {
    
    public int numVertices;
    public Vertex2[] adjList;  // array of Vertices
    public HashMap<String, Integer> vName_vIdx = new HashMap<>();  // helper map to get index of vertex in adjList
    
    public GraphAdjList2(String[] vertices) {
        this.numVertices = vertices.length;
        adjList = new Vertex2[numVertices];
        for (int i = 0; i < numVertices; i++ ) {  // initialize array of Vertices
            adjList[i] = new Vertex2(vertices[i]);
            vName_vIdx.put(adjList[i].vName, i);
        }
    }
    
    public void addEdge(String[] edge) {
        String from = edge[0];
        String to = edge[1];
        
        for (int i = 0; i < adjList.length; i++) {  // Find from-vertex, from array of Vertices. Could use added vName_vIdx.
            if (adjList[i].vName.equals(from)) {    // If found,
                Vertex2 curr = adjList[i];          // Find end of its adjVertices.
                while (curr.adjVertex != null) {
                    curr = curr.adjVertex;
                }
                curr.adjVertex = new Vertex2(to);    // Add to-vertex to the end.
            }
        }
    }
    
    public void addEdges(String[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            addEdge(edges[i]);
        }
    }
    
    public void addEdgeWithWeight(String[] edge) {  // same as addEdge but adding an edge with weight (Vfrom, Vto, weight)
        String from = edge[0];
        String to = edge[1];
        int weight = Integer.parseInt(edge[2]);
        
        for (int i = 0; i < adjList.length; i++) {  // Find from-vertex, from array of Vertices. Could use added vName_vIdx.
            if (adjList[i].vName.equals(from)) {    // If found,
                Vertex2 curr = adjList[i];          // Find end of its adjVertices.
                while (curr.adjVertex != null) {
                    curr = curr.adjVertex;
                }
                curr.adjVertex = new Vertex2(to, weight);    // Add to-vertex to the end, with weight.
            }
        }
    }
    
    public void addEdgesWithWeight(String[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            addEdgeWithWeight(edges[i]);
        }
    }
    
    public void printGraph() {
        for (int i = 0; i < adjList.length; i++) {
            Vertex2 curr = adjList[i];
            System.out.print(curr.vName + " has edges to: ");
            while (curr.adjVertex != null) {
                System.out.print(curr.adjVertex.vName + " ");
                curr = curr.adjVertex;
            }
            System.out.println();
        }
    }
    
    public void printAdjList() {
        for (int i = 0; i < adjList.length; i++) {
            Vertex2 curr = adjList[i];
            System.out.print(curr.vName + "->");
            boolean putCommna = false;
            while (curr.adjVertex != null) {
                if (putCommna) {
                    System.out.print("," + curr.adjVertex.vName);  // if second+ edge
                }
                else {
                    System.out.print(curr.adjVertex.vName);  // if first edge
                    putCommna = true;
                }
                curr = curr.adjVertex;
            }
            System.out.println();
        }
    }
    
    public class Vertex2 {
        public String vName;
        public Vertex2 adjVertex;
        public int weightFromAdj;  // weight from adjacent vertex to this vertex. To be recorded on adjVertex when adding edges.
        public int weightFromStart;  // weight from start vertex to this vertex, for Dijkstra's Algorithm. To be recorded on vertices in Vertex2[] adjList when running Dijkstra.
        public boolean foundSP;  // whether shortest path is found, for Dijkstra's Algorithm. To be recorded on vertices in Vertex2[] adjList when running Dijkstra.
        public String predecessor;  // immediate predecessor of this vertex, that leads to starting vertex of Shortest Path, for Dijkstra's Algorithm
        
        public Vertex2 (String vName) {
            this.vName = vName;
        }

        public Vertex2(String vName, int weightFromAdj) {  // constructor to be used if edges to vertices have weight
            this.vName = vName;
            this.weightFromAdj = weightFromAdj;
        }
    }
    
    public static void main(String[] args) {
        String[] vertices = new String[] {"V7", "V2", "V3", "V9", "V5", "V6"};
        GraphAdjList2 graph = new GraphAdjList2(vertices);
        graph.printGraph();
        System.out.println();
        String[][] edges = new String[][] {{"V7","V2"}, {"V7","V9"},{"V2","V3"}, {"V2","V6"}, {"V3","V5"}, {"V3","V6"}, {"V9","V3"}, {"V9","V5"}};
        graph.addEdges(edges);
        graph.printGraph();
        System.out.println();
        graph.printAdjList();
    }
    
}
