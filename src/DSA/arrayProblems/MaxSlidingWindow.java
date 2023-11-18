package DSA.arrayProblems;

import java.util.ArrayDeque;

/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window. (Could you solve it in linear time?)

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3 
Output: [3,3,5,5,6,7] 
Explanation: 
Window position                Max 
---------------               ----- 
[1  3  -1] -3  5  3  6  7       3 
 1 [3  -1  -3] 5  3  6  7       3 
 1  3 [-1  -3  5] 3  6  7       5 
 1  3  -1 [-3  5  3] 6  7       5 
 1  3  -1  -3 [5  3  6] 7       6 
 1  3  -1  -3  5 [3  6  7]      7 
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
        int[] maximums = findMaxAtEachWindow(nums, 3);
        for (int i : maximums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    /*
    Concept:
    The slide is implemented by:
    A for loop from i == 0 to i < nums.length (i is right boundary),
    while having a queue that stores index (in decreasing order of values to only consider possible maximum).
    but at each loop, checking the front of queue, trashing it if it's out of window's left boundary (i - k) 
    
    Programmatically:
    Go through array, addLast index of value to deque:
    While deque.last < value, Repeat pollLast and trash (because it is not max) until deque.last > value.
    If deque.last > value, Push index of value (as possible max when slide moves right).
    By doing this, the front of queue is always largest.
    
    Also pollFirst if deque.first is out of window's left boundary (== i - k)
    
    Then add value of deque.peak to return array "if i >= k - 1",
    because [[0 1 2] 3 4 5 6 7]: for k=3, i must increment to 2, to create window of size 3. then i increments until i < num.length.
     */
    public static int[] findMaxAtEachWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();  // stores index of value, keeping front is index of max value.
        // Slide moves nums.length - k times: if length=5, k=5, moves 0 times. if k=4 moves 1 times. if k=3 moves 2 times.
        int[] maximums = new int[nums.length - k + 1];  // return array (length is number of slide move + 1)
        int idx = 0;  // index of return array
        
        for (int i = 0; i < nums.length; i++) {
            
            // removing index that is out of window's left boundary
            if (!dq.isEmpty() && dq.peek() <= i - k) {  // deque.first is out of boundary of window
                dq.poll();  // trash
            }
            
            // removing number that is smaller than me, because window includes me, and numbers smaller than me can't be max
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {  // pollLast keeps front of deque maximum
                dq.pollLast();
            }
            
            dq.add(i);  // add me to deque, either as deque.front or as possible max if deque.front become out of left boundary
            
            if (i >= k - 1) {  // i must increment, from 0 to at least k - 1, to create window size of k
                maximums[idx++] = nums[dq.peek()];  // add top of queue (current max) to return array
            }
            // then i increment until i < num.length (right boundary), while removing (from queue) index that is out of window's left boundary
        }
        
        return maximums;
    }

}
