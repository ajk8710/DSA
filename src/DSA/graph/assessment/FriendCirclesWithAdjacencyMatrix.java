package DSA.graph.assessment;

import java.util.ArrayDeque;
import java.util.HashSet;

/*
There are N students in a class. Some of them are friends, while some are not.
Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C,
then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1,
then the ith and jth students are direct friends with each other, otherwise not.
And you have to output the total number of friend circles among all the students.

Input:
[[1,1,0],
[1,1,0],
[0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.

Input:
[[1,1,0],
[1,1,1],
[0,1,1]]
Output: 1
 */
public class FriendCirclesWithAdjacencyMatrix {
    public static void main(String[] args) {
        System.out.println(findNumFriendCircles(new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(findNumFriendCircles(new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
    
    // BFS on adjacency matrix.
    // Vertex is reachable to another vertex if mutual friend.
    // Each time there is disconnected vertex, increment number of friend circle.
    public static int findNumFriendCircles(int[][] matrix) {
        HashSet<Integer> visitedVertex = new HashSet<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int count = 0;  // number of friend circle
        
        for (int i = 0; i < matrix.length; i++) {  // for the row
            
            if (!visitedVertex.contains(i)) {  // If true at i > 0, it is disconnected vertex. (BFS on a vertex visits all other vertices if connected graph)
                count++;
                
                queue.add(i);
                visitedVertex.add(i);
                
                while (!queue.isEmpty()) {
                    int iVertex = queue.poll();

                    for (int j = 0; j < matrix.length; j++) {  // for the col
                        if (matrix[iVertex][j] == 1 && !visitedVertex.contains(j)) {  // add if unvisited vertex
                            queue.add(j);
                            visitedVertex.add(j);
                        }
                    }
                }
            }
            
        }
        
        return count;
    }
    
}
