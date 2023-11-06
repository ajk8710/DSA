package DSA.graph.problems;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

import DSA.graph.GraphAdjList2;
import DSA.graph.GraphAdjList2.Vertex2;

public class BFSDFS {
    public static void main(String[] args) {
        String[] vertices = new String[] {"V7", "V2", "V3", "V9", "V5", "V6", "VDisconnected"};
        GraphAdjList2 graph = new GraphAdjList2(vertices);
        String[][] edges = new String[][] {{"V7","V2"}, {"V7","V9"},{"V2","V3"}, {"V2","V6"}, {"V3","V5"}, {"V3","V6"}, {"V9","V3"}, {"V9","V5"}};
        graph.addEdges(edges);
        graph.printAdjList();
        System.out.println();
        
        System.out.print("BFS: ");
        BFS(graph);
        System.out.print("DFS: ");
        DFS(graph);
    }
    
    public static void BFS(GraphAdjList2 graph) {
        HashMap<String, Integer> vName_vIdx = new HashMap<>();  // helper map to get index of vertex in adjList
        for (int i = 0; i < graph.adjList.length; i++) {
            vName_vIdx.put(graph.adjList[i].vName, i);
        }
        
        HashSet<String> visitedVertexNames = new HashSet<>();  // a set to keep record of visited vertex
        ArrayDeque<Vertex2> queue = new ArrayDeque<>();  // queue for BFS
        
        for (Vertex2 v : graph.adjList) {  // loop to handle disconnected vertex
            if (!visitedVertexNames.contains(v.vName)) {  // if, to handle disconnected vertex

                // queue.add(graph.adjList[0]);  // enqueue first vertex - if not using outer loop for disconnected graph
                // visitedVertexNames.add(graph.adjList[0].vName);  // mark first vertex visited
                queue.add(v);  // enqueue vertex
                visitedVertexNames.add(v.vName);  // mark vertex visited
                
                while (!queue.isEmpty()) {
                    Vertex2 vertex = queue.poll();
                    System.out.print(vertex.vName + " ");  // visit
                    // visitedVertexNames.add(vertex.vName);  // don't mark visited when visiting, but when added to queue
                    
                    int idx = vName_vIdx.get(vertex.vName);  // find index of vertex from adjList
                    vertex = graph.adjList[idx];
                    
                    Vertex2 adjV = vertex.adjVertex;
                    while (adjV != null) {  // for every adjacent vertex
                        if (!visitedVertexNames.contains(adjV.vName)) {  // if vName not in set
                            queue.add(adjV);  // enqueue it
                            visitedVertexNames.add(adjV.vName);  // mark visited here, so it won't add duplicate to queue
                        }
                        adjV = adjV.adjVertex;
                    }
                }
                
            }  // end: if to handle disconnected vertex
        }  // end: loop to handle disconnected vertex
        
        System.out.println();
    }
    
    public static void DFS(GraphAdjList2 graph) {
        HashMap<String, Integer> vName_vIdx = new HashMap<>();  // helper map to get index of vertex in adjList
        for (int i = 0; i < graph.adjList.length; i++) {
            vName_vIdx.put(graph.adjList[i].vName, i);
        }
        
        HashSet<String> visitedVertexNames = new HashSet<>();  // a set to keep record of visited vertex
        ArrayDeque<Vertex2> stack = new ArrayDeque<>();  // stack for DFS
        
        for (Vertex2 v : graph.adjList) {  // loop to handle disconnected vertex
            if (!visitedVertexNames.contains(v.vName)) {  // if to handle disconnected vertex

                // queue.add(graph.adjList[0]);  // push first vertex - if not using outer loop for disconnected graph
                // visitedVertexNames.add(graph.adjList[0].vName);  // mark first vertex visited
                stack.addFirst(v);  // push vertex
                visitedVertexNames.add(v.vName);  // mark vertex visited
                
                while (!stack.isEmpty()) {
                    Vertex2 vertex = stack.pop();  // pop top (index 0)
                    System.out.print(vertex.vName + " ");  // visit
                    // visitedVertexNames.add(vertex.vName);  // don't mark visited when visiting, but when added to queue
                    
                    int idx = vName_vIdx.get(vertex.vName);  // find index of vertex from adjList
                    vertex = graph.adjList[idx];
                    
                    Vertex2 adjV = vertex.adjVertex;
                    while (adjV != null) {  // for every adjacent vertex
                        if (!visitedVertexNames.contains(adjV.vName)) {  // if vName not in set
                            stack.addFirst(adjV);  // push it
                            visitedVertexNames.add(adjV.vName);  // mark visited here, so it won't add duplicate to queue
                        }
                        adjV = adjV.adjVertex;
                    }
                }
                
            }  // end: if to handle disconnected vertex
        }  // end: loop to handle disconnected vertex
        
        System.out.println();
    }
    
}
