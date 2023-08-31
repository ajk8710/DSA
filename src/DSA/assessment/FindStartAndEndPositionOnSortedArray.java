package DSA.assessment;

// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
// Runtime complexity must be in the order of O(log n).
// If the target is not found in the array, return [-1, -1].

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
public class FindStartAndEndPositionOnSortedArray {
    public static void main(String[] args) {
        int[] rv = findPositionOnArray(new int[] {5,7,7,8,8,10}, 8);
        System.out.println("new int[] {5,7,7,8,8,10}, 8: ");
        for (int i : rv) {
            System.out.print(i + " ");
        }
        
        rv = findPositionOnArray(new int[] {5,7,7,8,8,10}, 6);
        System.out.println("\nnew int[] {5,7,7,8,8,10}, 6: ");
        for (int i : rv) {
            System.out.print(i + " ");
        }
        
        rv = findPositionOnArray(new int[] {1,1,1,2,2,3}, 1);
        System.out.println("\nnew int[] {1,1,1,2,2,3}, 1: ");
        for (int i : rv) {
            System.out.print(i + " ");
        }
        
    }
    
    // Binary search twice. One that keeps going left once found target. The other keeps going right once found target.
    public static int[] findPositionOnArray(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int leftmostTarget = -1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (arr[mid] == target) {
                leftmostTarget = mid;
                right = mid - 1;
                // instead of returning upon found like normal binary search, continue on while reducing boundary to left
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        left = 0;
        right = arr.length - 1;
        int rightmostTarget = -1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (arr[mid] == target) {
                rightmostTarget = mid;
                left = mid + 1;
                // instead of returning upon found like normal binary search, continue on while reducing boundary to right
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return new int[] {leftmostTarget, rightmostTarget};
        
        /* Following way is not log(n)
        if (min == -1) {
            System.out.println("[-1, -1]");
        }
        else {
            for (int i = max + 1; i < arr.length; i++) {
                if (arr[max] == arr[i]) {
                    max++;
                }
            }
            for (int i = min - 1; i >= 0; i--) {
                if (arr[min] == arr[i]) {
                    min--;
                }
            }
        }
        System.out.println("[" + min + ", " + max + "]");
        */
    }
    
}
