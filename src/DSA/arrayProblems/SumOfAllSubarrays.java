package DSA.arrayProblems;

// Find sum of all sub-arrays.
// A sub-array of an array is an array composed of a common block of the original array¡¯s elements. i.e. contiguous part of the array.
// Example:
// Consider Array: A=[1, 2, 3, 4]
// The sub-arrays are: [1], [2], [3], [4], [1,2], [2,3], [3,4], [1,2,3], [2,3,4] and [1,2,3,4].
// Sum of all sub-array is 1 + 2 + 3 + 4 + 1 + 2 + 2 + 3 + 3 + 4 + 1 + 2 + 3 + 2 + 3 + 4 + 1 + 2 + 3 + 4 = 50
public class SumOfAllSubarrays {

    public static void main(String[] args) {
        System.out.println(sumofAllSubarrays(new int[] {1, 2, 3, 4}));
        System.out.println(sumofAllSubarrays(new int[] {1, 2, 3}));
        System.out.println();
        System.out.println(sumOfAllSubarraysNaive(new int[] {1, 2, 3, 4}));
        System.out.println(sumOfAllSubarraysNaive(new int[] {1, 2, 3}));
    }
    
    /* [1, 2, 3, 4] :
    Occurrence of index 0 from sub-array starting with itself: [1], [1,2], [1,2,3], [1,2,3,4] ==> 4, which is (n - i)
    Occurrence of index 1 from sub-array starting with itself: [2], [2,3], [2,3,4]            ==> 3, which is (n - i)
    Occurrence of index 2 from sub-array starting with itself: [3], [3,4]                     ==> 2, which is (n - i)
    Occurrence of index 3 from sub-array starting with itself: [4]                            ==> 1, which is (n - i)
    
    Occurrence of index 0 from sub-array that does not start with itself:                                    ==> 0, which is (n - i) * i
    Occurrence of index 1 from sub-array that does not start with itself: [1,2], [1,2,3], [1,2,3,4]          ==> 3, which is (n - i) * i
    Occurrence of index 2 from sub-array that does not start with itself: [1,2,3], [1,2,3,4], [2,3], [2,3,4] ==> 4, which is (n - i) * i
    Occurrence of index 3 from sub-array that does not start with itself: [1,2,3,4], [2,3,4], [3,4]          ==> 3, which is (n - i) * i
    
    Sum of all sub-array = for every index: index value * its occurrences from every sub-arrays = arr[i] * [(n - i) + (n - i) * i]
    Simplifying math expression: [(n - i) + (n - i) * i] = after taking same term (n - i) out = (n - i) * (1 + i)
    Thus: arr[i] * (n - i) * (1 + i)
    */
    public static int sumofAllSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {  // O(n)
            sum += arr[i] * (n - i) * (1 + i);
        }
        return sum;
    }
    
    // Naive version: O(n^2)
    // For each index i: Generate sub-arrays starting from index i. Sum them. Add to total sum.
    public static int sumOfAllSubarraysNaive(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {  // starting index
            int sumFromArraysStartingI = 0;  // sum from sub-arrays starting from index i
            for (int j = i; j < n; j++) {  // ending index
                sumFromArraysStartingI += arr[j];  // this sum accumulates as ending index j increases: 0, 0 + 1, 0 + 1 + 2
                sum += sumFromArraysStartingI;
            }
        }
        return sum;
    }

}
