package DSA.graph.problems;

import java.util.ArrayDeque;

/*
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.
Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */
class Position {  // custom class to save index (i, j) into queue
    public int x;
    public int y;
    public Position (int i, int j) {x = i; y = j;}
}

public class CountIsland {
    
    public static void main(String[] args) {
        String[][] grid = new String[][] {{"1","1","1","1","0"},{"1","1","0","1","0"},{"1","1","0","0","0"},{"0","0","0","0","0"}};
        System.out.println("Count: " + countIsland(grid));
        grid = new String[][] {{"1","1","0","0","0"},{"1","1","0","0","0"},{"0","0","1","0","0"},{"0","0","0","1","1"}};
        System.out.println("Count: " + countIsland(grid));
        grid = new String[][] {{"1","1","0","0","1","1","1","1","0","0","0","1"}};
        System.out.println("Count: " + countIsland(grid));
    }
    
    static int[][] visited;  // visited array as static variable because I don't want to pass this every time when I call methods.
    
    // Consider each index (row, col) as a vertex.
    // Starting from index (0, 0), if it's a land and not yet visited, increment numIsland.
    // Explore connected vertices using either BFS/DFS, marking them visited.
    public static int countIsland(String[][] worldMap) {
        int numIsland = 0;
        
        int numRow = worldMap.length;
        int numCol = worldMap[0].length;
        visited = new int[numRow][numCol];  // initialize visited array
        
        for (int i = 0; i < numRow; i++) {  // for every index of world map
            for (int j = 0; j < numCol; j++) {
                if (worldMap[i][j].equals("1") && visited[i][j] == 0) {  // If it's a land and not yet visited,
                    numIsland++;                                         // I found a new island.
                    bfs(i, j, worldMap);  // BFS on index (i, j). Explore an island.
                }
            }
        }
        
        visited = null;  // reset static variable
        return numIsland;
    }
    
    public static void bfs(int i, int j, String[][] worldMap) {
        ArrayDeque<Position> queue = new ArrayDeque<>();  // queue for bfs
        Position pos = new Position(i, j);
        queue.add(pos);     // add position to queue
        visited[i][j] = 1;  // mark visited
        
        while (!queue.isEmpty()) {  // explore island, marking them visited
            pos = queue.poll();
            int row = pos.x;
            int col = pos.y;
            
            int left = col - 1;
            int right = col + 1;
            int up = row - 1;
            int down = row + 1;
            
            // Check if surrounding four positions are within boundary of world map, and is a land, and not visited:
            // If so, add to queue and mark visited
            if (isInBoundary(row, left) && worldMap[row][left].equals("1") && visited[row][left] == 0) {
                queue.add(new Position(row, left));
                visited[row][left] = 1;
            }
            if (isInBoundary(row, right) && worldMap[row][right].equals("1") && visited[row][right] == 0) {
                queue.add(new Position(row, right));
                visited[row][right] = 1;
            }
            if (isInBoundary(up, col) && worldMap[up][col].equals("1") && visited[up][col] == 0) {
                queue.add(new Position(up, col));
                visited[up][col] = 1;
            }
            if (isInBoundary(down, col) && worldMap[down][col].equals("1") && visited[down][col] == 0) {
                queue.add(new Position(down, col));
                visited[down][col] = 1;
            }
        }
    }
    
    // Return true if the index is within boundary of world map
    public static boolean isInBoundary(int row, int col) {
        int numRow = visited.length;  // dimension of visited array is same as dimension of world map.
        int numCol = visited[0].length;
        return -1 < row && row < numRow && -1 < col && col < numCol;
    }
    
}
