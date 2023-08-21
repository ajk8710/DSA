package DSA.Searching;

public class LinearSearch {

    public static void main(String[] args) {
        
        findTarget(new int[] {1,2,3,4,5}, 1);
        findTarget(new int[] {1,2,3,4,5}, 3);
        findTarget(new int[] {1,2,3,4,5}, 5);
        findTarget(new int[] {1,2,3,4,5}, 6);
        
        largestThree(new int[] {1,2,3,4,5});
        largestThree(new int[] {5,4,3,2,1});
        largestThree(new int[] {-212, 0, 2, 3, 80, 1,2,3,4,5, -1 ,0, 100 ,20, 39});

    }

    public static boolean findTarget(int[] arr, int target) {
        int numComparison = 0;
        for (int i = 0; i < arr.length; i++) {
            numComparison++;
            if (arr[i] == target) {
                System.out.println("Found at index " + i + ". Number of Comparison: " + numComparison);
                return true;
            }
        }
        System.out.println("Not Found. Number of Comparison: " + numComparison);
        return false;
    }
    
    public static int[] largestThree(int[] arr) {  // not done yet
        if (arr.length < 3) {
            System.out.println("array length must be at least 3");
            return null;
        }
        
        int firstLarge = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;
        int thirdLarge = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstLarge) {
                thirdLarge = secondLarge;
                secondLarge = firstLarge;
                firstLarge = arr[i];
            }
            else if (arr[i] > secondLarge) {
                thirdLarge = secondLarge;
                secondLarge = arr[i];
            }
            else if (arr[i] > thirdLarge) {
                thirdLarge = arr[i];
            }
        }
        
        System.out.println("First Large: " + firstLarge);
        System.out.println("Second Large: " + secondLarge);
        System.out.println("Third Large: " + thirdLarge);
        return null;
    }
    
}
