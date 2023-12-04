package DSA.queue.problem;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
Queues: A queue of people.
You are given the names of N people and the time at which they arrive.
You have an empty queue.
As soon as a person arrives, you add their name to the queue.
Given the names of the people and their arrival times print the final queue after all N people have arrived.

Note:
1. No two people have the same name. 
2. No two people have the same arrival time. 
3. The input arrival time is not sorted (See sample input). 

Input:
Name={Jim ,Sam, Roy ,John}
Time={5, 1, 4, 2}

Output:
Sam John Roy Jim
Explanation:
There are 4 people with names Jim, Sam, Ray, John, Jim arrives at t=5 minutes,
Sam arrives at t=1 minutes, Ray arrives at t=4 minutes and John arrives at t=2 minutes.
*/

// Solving problem by TreeMap.
public class PriorityQueueOfPeopleUsingTreeMap {
    
    // Uses the fact that TreeMap is sorted on keys. (homogeneous key that implements Comparable interface) (Unlike TreeMap, HashMap is not sorted)
    // Iteration on TreeMap is ordered.
    public static void printFinalQueue(String[] names, int[] times) {
        TreeMap<Integer, String> time_name = new TreeMap<>();  // map of time to name
        
        // map (key: arrival time, value: name)
        for (int i = 0; i < names.length; i++) {
            time_name.put(times[i], names[i]);
        }
        
        // iterate on TreeMap, add names to queue
        Queue<String> queue = new ArrayDeque<>();
        for (Map.Entry<Integer, String> entry : time_name.entrySet()) {
            queue.add(entry.getValue());
        }
        
        // print names in queue
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
    
    public static void main(String[] args) {
        String[] names = {"Jim", "Sam", "Roy", "John"};
        int[] times = {5, 1, 4, 2};
        printFinalQueue(names, times);
    }
    
}
