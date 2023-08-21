package DSA.Searching;

public class BinarySearch {
    
    public static void main(String[] args) {
        System.out.println(" -- Iterative --");
        System.out.println("{1, 2, 3, 4, 5, 6, 7, 8}, Find 3");
        binarySearchIterative(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 3);
        System.out.println();
        System.out.println("{5, 8, 100, 200, 1000, 1200}, Find 8");
        binarySearchIterative(new int[] {5, 8, 100, 200, 1000, 1200}, 8);
        System.out.println();
        System.out.println("{1, 2, 3, 4, 5, 6, 7, 8}, Find 0");
        binarySearchIterative(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 9);
        
        System.out.println();
        System.out.println(" -- Recursive --");
        System.out.println("{1, 2, 3, 4, 5, 6, 7, 8}, Find 3");
        binarySearchRecursive(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 0, 7, 3, 1);
        System.out.println();
        System.out.println("{5, 8, 100, 200, 1000, 1200}, Find 8");
        binarySearchRecursive(new int[] {5, 8, 100, 200, 1000, 1200}, 0, 5, 8, 1);
        System.out.println();
        System.out.println("{1, 2, 3, 4, 5, 6, 7, 8}, Find 0");
        binarySearchRecursive(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 0, 7, 9, 1);
        
    }
    
    public static boolean binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int itr = 0;
        while (left <= right) {
            itr++;
            int mid = (left + right) / 2;  // integer division
            
            // System.out.println("left & right index: " + left + " " + right);
            // System.out.println("mid index: " + mid + ", mid element: " + arr[mid]);
            
            if (arr[mid] == target) {
                System.out.println("Found at index " + mid + " after " + itr + " iterations.");
                return true;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println("Not found after " + itr + " iterations.");
        return false;
    }

    public static boolean binarySearchRecursive(int[] arr, int left, int right, int target, int itr) {
        if (left > right) {  // base case
            System.out.println("Not found after " + itr + " comparison.");
            return false;
        }
        
        int mid = (left + right) / 2;  // integer division
        if (arr[mid] == target) {  // base case
            System.out.println("Found at index " + mid + " after " + itr + " comparison.");
            return true;
        }
        else if (arr[mid] < target) { // recursive call
            left = mid + 1;
            itr++;
            return binarySearchRecursive(arr, left, right, target, itr);
        }
        else { // recursive call
            right = mid - 1;
            itr++;
            return binarySearchRecursive(arr, left, right, target, itr);
        }
        
    }
    
}
