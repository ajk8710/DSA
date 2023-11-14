package DSA.graph.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import DSA.graph.GraphAdjList2;

public class Kruskal {
    public static void main(String[] args) {
        String[] vertices = new String[] {"V1", "V2", "V3", "V4", "V5", "V6"};
        GraphAdjList2 graph = new GraphAdjList2(vertices);
        String[][] edges = new String[][] {{"V1","V2","5"}, {"V1","V4","3"},{"V2","V3","4"}, {"V2","V6","6"}, {"V3","V5","3"}, {"V3","V6","3"}, {"V4","V3","2"}, {"V4","V5","6"}};
        graph.addEdgesWithWeight(edges);
        graph.printAdjList();
        System.out.println();
        
        List<Edge> edgesOfMST = kruskal(vertices, edges);
        for (Edge edge : edgesOfMST) {
            System.out.println(edge.weight + " " + edge.v1 + " " + edge.v2);
        }
    }
    
    // Create min-heap of edges. Delete minimum weighted edge from heap. If the edge contains unvisited vertex, add to MST. 
    public static List<Edge> kruskal(String[] vertices, String[][] edges) {
        Heap edgeList = new Heap();  // edgeList.edges is min-heap of edges
        for (String[] edge : edges) {  // Insert each edge to edgeList (converting String[][] to min-heap of edges)
            edgeList.insert(Double.parseDouble(edge[2]), edge[0], edge[1]);
        }
        
        /*
        // print all edges of heap from position 0 to last
        for (int i = 0; i < edgeList.size; i++) {
            System.out.println(edgeList.edges[i].weight + " " + edgeList.edges[i].v1 + " " + edgeList.edges[i].v2);
        }
        */
        
        HashSet<String> visitedVertices = new HashSet<>();
        List<Edge> edgesOfMST = new ArrayList<>();
        
        int numVertices = vertices.length;
        while (visitedVertices.size() < numVertices) {  // until all vertices are visited
            Edge minEdge = edgeList.deleteMin();  // delete minimum edge from heap
            if (!visitedVertices.contains(minEdge.v1) || !visitedVertices.contains(minEdge.v2)) {  // if edge has unvisited vertex
                visitedVertices.add(minEdge.v1);  // mark vertex visited
                visitedVertices.add(minEdge.v2);
                edgesOfMST.add(minEdge);  // add edge to MST
                // System.out.println(minEdge.weight + " " + minEdge.v1 + " " + minEdge.v2);
            }
        }
        
        return edgesOfMST;
    }
}

// Edge
class Edge {
    public double weight;
    public String v1;
    public String v2;
    
    public Edge(double weight, String v1, String v2) {
        this.weight = weight;
        this.v1 = v1;
        this.v2 = v2;
    }
}

// Array representation of heap of edges.
// Insertion and deletion ensure minimum is the root.
class Heap {
    public Edge[] edges = new Edge[100];
    public int size = 0;
    
    // Insert while keeping heap property. Insert at the end, then move it up to proper position.
    public void insert(double weight, String v1, String v2) {
        Edge e = new Edge(weight, v1, v2);
        edges[size] = e;
        size++;
        upHeap(size - 1);
    }
    
    // Private helper method for insert
    private void upHeap(int i) {
        if (i > 0) {
            if (edges[(i - 1) / 2].weight > edges[i].weight) {  // if parent is bigger then me
                Edge temp = new Edge(edges[i].weight, edges[i].v1, edges[i].v2);  // copy me to temp before swap
                edges[i] = edges[(i - 1) / 2];  // swap me and parent
                edges[(i - 1) / 2] = temp;
                upHeap((i - 1) / 2);  // continue until swap is not necessary or is at root
            }
        }
    }
    
    // Delete while keeping heap property.
    // It deletes minimum of tree (root) and moves next minimum to root,
    // by moving what's at the end to the root, then move it down while swapping with smaller child.
    public Edge deleteMin() {
        Edge min = edges[0];
        size--;
        edges[0] = edges[size];
        downHeap(0);
        return min;
    }
    
    // Private helper method for deleteMin
    private void downHeap(int m) {
        int i = 0;                // i is m's smaller child
        if ((2 * m + 2) < size) { // if both children exist, i = min(left, right)
            if (edges[2 * m + 2].weight <= edges[2 * m + 1].weight) {
                i = 2 * m + 2;
            }
            else {
                i = 2 * m + 1;
            }
        }
        else if ((2 * m + 1) < size) { // if only left child exists, i = left child
            i = 2 * m + 1;
        }
        // if i > 0, then i exists as smaller child of m. Swap if m > i.
        if (i > 0 && edges[m].weight > edges[i].weight) {
            Edge temp = edges[i];
            edges[i] = edges[m];  // swap m & i
            edges[m] = temp;
            downHeap(i);  // continue until swap is not necessary or is at leaf
        }
    }
    
} // end of Heap class
