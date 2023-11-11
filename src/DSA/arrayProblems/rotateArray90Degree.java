package DSA.arrayProblems;

/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
Example 1:
Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:
Given input matrix =
[ [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],
rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
public class rotateArray90Degree {    
    /*
    [ [ 5, 1, 9,11], 5->11, 11->16, 16->15, 15->5, then 1->10, 10->12, 12->13, 13->1,
      [ 2, 4, 8,10],   then 9->7, 7->14, 14->2, 2->9 This is outer square, runs through (rightBound(3) - leftBound(0)) times.
      [13, 3, 6, 7], Shrink boundaries: Right, Left, Top, Bottom.
      [15,14,12,16]  4->8, 8->6, 6->3, 3->4. This is inner square, runs through (rightBound(2) - leftBound(1)) times
    ]
     */
    public static void rotateArray(int[][] arr) {
        int left = 0;
        int right = arr.length - 1;
        int top = 0;
        int bottom = arr.length - 1;
        
        while (left < right) {  // handle from outermost square then go inner square
            for (int i = 0; i < right - left; i++) {  // run (right - left) times
                int temp = arr[top][left + i];
                arr[top][left + i] = arr[bottom - i][left];
                arr[bottom - i][left] = arr[bottom][right - i];
                arr[bottom][right - i] = arr[top + i][right];
                arr[top + i][right] = temp;
            }
            
            // go to inner square
            left++;
            right--;
            top++;
            bottom--;
        }
    }
    
    public static void main(String[] args) {
        int[][] arr1 = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.printf("%2s", arr1[i][j]);
            }
            System.out.println(" ]");
        }
        
        System.out.println("Rotate: ");
        rotateArray(arr1);
        
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.printf("%2s", arr1[i][j]);
            }
            System.out.println(" ]");
        }
        System.out.println();
        
        int[][] arr2 = new int[][] {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr2[0].length; j++) {
                System.out.printf("%3s", arr2[i][j]);
            }
            System.out.println(" ]");
        }
        
        System.out.println("Rotate: ");
        rotateArray(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr2[0].length; j++) {
                System.out.printf("%3s", arr2[i][j]);
            }
            System.out.println(" ]");
        }
        System.out.println();
    }
    
}
