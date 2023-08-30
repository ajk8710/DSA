package DSA.assessment;

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
// You are given a target value to search. If found in the array return its index, otherwise return -1.
// You may assume no duplicate exists in the array.
// Your algorithm's runtime complexity must be in the order of O(log n).
// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Input: nums = [4,5,6,7,0,1], target = 0
// Output: 4

// 4 5 1 2 3
public class SortedArrayRotatedAtPivot {

    public static void main(String[] args) {
        int rv = sortedArrayRotatedAtPivot(new int[] {4,5,6,7,0,1,2}, 0);
        System.out.println("{4,5,6,7,0,1,2}, 0: Index:" + rv);
        rv = sortedArrayRotatedAtPivot(new int[] {4,5,6,7,0,1,2}, 3);
        System.out.println("{4,5,6,7,0,1,2}, 3: Index:" + rv);
        rv = sortedArrayRotatedAtPivot(new int[] {4,5,6,7,0,1}, 0);
        System.out.println("{4,5,6,7,0,1}, 0: Index:" + rv);
    }

    public static int sortedArrayRotatedAtPivot(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;  // get mid
            
            if (arr[mid] == target) {  // return if mid is target
                return mid;
            }
            
            // the array rotated around pivot (so pivot is technically not unkown as problem states)
            // so pivot is always the left end (or can say the right end)
            // so whatever mid I pick, if it is greater than left end, then left side of array is sorted. If not, the right side is sorted.
            if (arr[left] <= arr[mid]) {  // if left side is sorted
                if (arr[left] <= target && target < arr[mid]) {   // if target seats between sorted array
                    right = mid - 1;                              // look up in sorted array
                }
                else {
                    left = mid + 1;                               // else, go to the other half (right side), get new mid and repeat
                }
            }
            else {  // if right side is sorted
                if (arr[mid] < target && target <= arr[right]) {  // if target seats between sorted array
                    left = mid + 1;                               // look up in sorted array
                }
                else {
                    right = mid - 1;                               // else, go to other half (left side), get new mid and repeat
                }
            }
        }
        
        return -1;
    }
    
}