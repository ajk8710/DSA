package DSA.arrayProblems;

/*
Write an efficient algorithm (log n complexity) that searches for a value in an m x n matrix.
This matrix has the following properties: 
Integers in each row are sorted in ascending from left to right. 
Integers in each column are sorted in ascending from top to bottom. 
Example: 
Consider the following matrix: 
[ 
  [1,   4,  7, 11, 15], 
  [2,   5,  8, 12, 19], 
  [3,   6,  9, 16, 22], 
  [10, 13, 14, 17, 24], 
  [18, 21, 23, 26, 30] 
] 
Given target = 5, return true. 
Given target = 20, return false.
 */
public class SearchFromSortedMatrix {
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,   4,  7, 11, 15}, 
                                      {2,   5,  8, 12, 19}, 
                                      {3,   6,  9, 16, 22}, 
                                      {10, 13, 14, 17, 24}, 
                                      {18, 21, 23, 26, 30}};
        System.out.println("Find 5: " +  find(matrix, 5));
        System.out.println("Find 20: " +  find(matrix, 20));
    }
    
    // Start from top right (pivot).
    // Everything left of it is less than pivot.
    // Everything bottom of it is greater than pivot.
    // It's basically a binary search.
    public static boolean find(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        
        // while within boundary of matrix (row always increases, column always decreases)
        while (row < matrix.length && col > -1) {
            int pivot = matrix[row][col];
            if (target == pivot) return true;
            if (target < pivot) col--;  // if target is smaller, go left
            else row++;  // else go down
        }
        
        return false;
    }

}
