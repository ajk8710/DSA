package DSA.graph.assessment;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
Given a matrix of dimension M * N where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0: Empty cell
1: Cells have fresh oranges
2: Cells have rotten oranges
Determine what is the minimum time required so that all the oranges become rotten.
A rotten orange at index (i,j ) can rot other fresh oranges which are its neighbors (up, down, left and right).
If it is impossible to rot every orange then simply return -1.
Examples:
Input: arr[][] = { {2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1} };
Output: 2
 */
public class RottenOrangesWithMatrix {
    public static void main(String[] args) {
        System.out.println(rotOranges(new int[][] { {2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1} }));
    }
    
    // Concept:
    // Run bfs on each rotten orange (multi-source bfs). Each time group of neighbor oranges added to queue, increment time.
    // If number of fresh orange is not 0 at the end, return -1.
    
    // Programmatically:
    // Get initial state: Go through matrix. If fresh, increment fresh count. If rotten, add position to queue.
    // Then Run BFS:
    // While queue is not empty: Increment timer
    //     for number of queue.size: poll() & rot neighboring fresh oranges and them to queue.
    public static int rotOranges(int[][] matrix) {
        int time = 0;
        int numFresh = 0;
        
        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();
        // do not need to record visited position because we turn fresh to rotten, & only add to queue if fresh
        // int[][] visited = new int[matrix.length][matrix[0].length];
        
        // Get initial state of matrix
        for (int i = 0; i < matrix.length; i++) {  // go through matrix
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {  // count number of fresh oranges
                    numFresh++;
                }
                else if (matrix[i][j] == 2) {  // add initial rotten oranges to queue
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    queue.add(list);
                }
            }
        }
        
        // BFS
        while (!queue.isEmpty() && numFresh > 0) {
            time++;
            
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {  // like doing level order traversal of tree
                List<Integer> pos = queue.poll();  // queue contains rotten oranges of current timer
                int row = pos.get(0);
                int col = pos.get(1);
                
                int left = col - 1;
                int right = col + 1;
                int up = row - 1;
                int down = row + 1;
                
                // Check if surrounding four positions are within boundary of matrix, and is fresh orange:
                // If so, change to rotten and add to queue, decrement numFresh.
                if (isInBoundary(row, left, matrix) && matrix[row][left] == 1) {
                    matrix[row][left] = 2;
                    List<Integer> list = new ArrayList<>();
                    list.add(row);
                    list.add(left);
                    queue.add(list);
                    numFresh--;
                }
                if (isInBoundary(row, right, matrix) && matrix[row][right] == 1) {
                    matrix[row][right] = 2;
                    List<Integer> list = new ArrayList<>();
                    list.add(row);
                    list.add(right);
                    queue.add(list);
                    numFresh--;
                }
                if (isInBoundary(up, col, matrix) && matrix[up][col] == 1) {
                    matrix[up][col] = 2;
                    List<Integer> list = new ArrayList<>();
                    list.add(up);
                    list.add(col);
                    queue.add(list);
                    numFresh--;
                }
                if (isInBoundary(down, col, matrix) && matrix[down][col] == 1) {
                    matrix[down][col] = 2;
                    List<Integer> list = new ArrayList<>();
                    list.add(down);
                    list.add(col);
                    queue.add(list);
                    numFresh--;
                }
            }
        }
        
        return numFresh == 0 ? time : -1;
    }
    
    public static boolean isInBoundary(int i, int j, int[][] matrix) {
        int numRow = matrix.length;
        int numCol =  matrix[0].length;
        return -1 < i && i < numRow && -1 < j && j < numCol;
    }
}
