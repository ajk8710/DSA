package DSA.graph.problems;

import java.util.HashMap;

import DSA.graph.GraphAdjList2;
import DSA.graph.GraphAdjList2.Vertex2;

/*
Dijkstra's Algorithm gives you shortest path from one node to every other node.

For every node, initialize node.weightFromStart = weight from start node to this node or Infinity, node.foundSP = false.
Pick a starting node. it¡¯s node.weightFromStart = 0, node.foundSP = true.
Loop numNode - 1 times:
    Find a node N such that foundSP = false & weightFromStart is minimum. (Shortest Path to N is found)
        For each neighbor (NN) of node N:
            if foundSP = false, then NN.weightFromStart = min(NN.weightFromStart, N.weightFromStart + weight from N to NN)
            (i.e. update path to other nodes NNs, comparing path I knew with new found path through node N)
To keep track of path: Have a predecessor field. Update predecessor when weightFromStart is updated.
 */
public class Dijkstra {
    public static void main(String[] args) {
        String[] vertices = new String[] {"V1", "V2", "V3", "V4", "V5", "V6"};
        GraphAdjList2 graph = new GraphAdjList2(vertices);
        String[][] edges = new String[][] {{"V1","V2","5"}, {"V1","V4","3"},{"V2","V3","4"}, {"V2","V6","6"}, {"V3","V5","3"}, {"V3","V6","3"}, {"V4","V3","2"}, {"V4","V5","6"}};
        graph.addEdgesWithWeight(edges);
        graph.printAdjList();
        System.out.println();
        
        dijkstra(graph.adjList, "V1");
        for (int i = 0; i < graph.adjList.length; i++) {
            System.out.print(graph.adjList[i].vName + ": Weight from V1: " + graph.adjList[i].weightFromStart);
            
            System.out.print(", SP to V1: ");  // print shortest path, following predecessor
            String predecessor = graph.adjList[i].predecessor;
            while (predecessor != null) {
                int predecessorIdx = graph.vName_vIdx.get(predecessor);  // get index of predecessor in adjList.
                System.out.print(graph.adjList[predecessorIdx].vName + " ");  // print predecessor
                predecessor = graph.adjList[predecessorIdx].predecessor;
            }
            System.out.println();
        }
    }
    
    public static void dijkstra(Vertex2[] adjList, String startVertexName) {
        HashMap<String, Integer> vName_vIdx = new HashMap<>();  // helper map to get index of vertex in adjList
        for (int i = 0; i < adjList.length; i++) {
            vName_vIdx.put(adjList[i].vName, i);
        }
        
        // 1-1. For every node, initialize node.weightFromStart = infinity, node.foundSP = false.
        for (int i = 0; i < adjList.length; i++) {
            adjList[i].foundSP = false;  // technically not a necessary line of code b/c it's already initialized as false
            adjList[i].weightFromStart = Integer.MAX_VALUE;
        }
        
        // 1-2. For neighboring vertices of start-vertex, set node.weightFromStart = weight from start node to this node.
        int startVerexIdx = vName_vIdx.get(startVertexName);  // get index of start-vertex using hashmap vName_vIdx
        Vertex2 curr = adjList[startVerexIdx];  // curr = start-vertex
        while (curr.adjVertex != null) {  // for its every neighboring vertices
            int adjVertexIdx = vName_vIdx.get(curr.adjVertex.vName);  // get index of neighbor-vertex using hashmap vName_vIdx
            adjList[adjVertexIdx].weightFromStart = curr.adjVertex.weightFromAdj;  // record neighbor-vertex.weightFromStart
            adjList[adjVertexIdx].predecessor = startVertexName;  // update predecessor: obviously start-vertex since it's the neighbor
            curr = curr.adjVertex;
        }
        
        // 1-3. For start node, node.weightFromStart = 0, node.foundSP = true.
        adjList[startVerexIdx].foundSP = true;
        adjList[startVerexIdx].weightFromStart = 0;
        
        // 2. Loop numNode - 1 times
        for (int i = 0; i < adjList.length - 1; i++) {
            // 2-1. Find a node N such that foundSP = false & weightFromStart is minimum. (Shortest Path to N is found)
            int minWeightFromStart = Integer.MAX_VALUE;
            Integer minVIdx = null;
            for (int j = 0; j < adjList.length; j++) {  // loop to find minimum: could implement and use min-heap for better performance
                if (adjList[j].foundSP == false && adjList[j].weightFromStart < minWeightFromStart) {  // find node N
                    minVIdx = j;  // index of N from adjList
                    minWeightFromStart = adjList[j].weightFromStart;
                }
            }
            adjList[minVIdx].foundSP = true;  // Shortest Path to N is found
            
            // 3. For each neighbor (NN) of node N:
            curr = adjList[minVIdx];  // curr = node N
            while (curr.adjVertex != null) {
                int adjVertexIdx = vName_vIdx.get(curr.adjVertex.vName);  // index of neighbor in adjList
                
                // 3-1. If NN.foundSP = false, then NN.weightFromStart = min(NN.weightFromStart, N.weightFromStart + weight from N to NN)
                if (adjList[adjVertexIdx].foundSP == false) {
                    int temp = adjList[adjVertexIdx].weightFromStart;
                    adjList[adjVertexIdx].weightFromStart = Math.min(adjList[adjVertexIdx].weightFromStart, adjList[minVIdx].weightFromStart + curr.adjVertex.weightFromAdj);
                    if (temp != adjList[adjVertexIdx].weightFromStart) {  // if weightFromStart updated
                        adjList[adjVertexIdx].predecessor = adjList[minVIdx].vName;  // update predecessor that leads to starting vertex in Shortest Path
                    }
                }
                curr = curr.adjVertex;
            }
        }
    }
    
}
