package DSA.dynamicProgramming;

// Find maximum subarray. Maximum subarray is contiguous array within given array where sum is max.
// Input: [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max Sum of Array: " + findMaximumSubarray(arr));
        
        System.out.println("Max Sum of Array: " + findMaximumSubarrayForAllIndex(arr));
        System.out.println("Printing max sum up to the index:");
        for (int i : arr) {  // printing max sum up to the index
            System.out.print(i + " ");
        }
    }
    
    // Sum previous result with me. If sum is smaller, take me. If sum is bigger, take sum.
    // Return max sum.
    public static int findMaximumSubarray(int[] arr) {
        int sum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int me = arr[i];
            int newSum = sum + me;  // sum previous result with me
            
            if (newSum < me) sum = me;  // if sum is smaller, discard previous result. I'm new sum.
            else sum = newSum;          // otherwise, take sum.
            
            if (sum > maxSum) maxSum = sum;
        }
        return maxSum;
    }
    
    // Same concept but saving results to index and using it, instead of a variable sum.
    public static int findMaximumSubarrayForAllIndex(int[] arr) {
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int me = arr[i];
            int newSum = arr[i - 1] + me;  // sum previous result with me
            
            if (newSum > me) arr[i] = newSum;  // if sum is bigger, record new sum to my index. Otherwise leave me as is.
            if (arr[i] > maxSum) maxSum = arr[i];  // keeping track of maximum.
        }
        return maxSum;
    }

}
