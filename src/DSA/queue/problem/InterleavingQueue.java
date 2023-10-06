package DSA.queue.problem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

// Given a queue of integers of even length, rearrange the elements by 
// interleaving the first half of the queue with the second half of the queue.
// Only a stack can be used as an auxiliary space.
// 
// Input :  1 2 3 4
// Output : 1 3 2 4
// Input : 11 12 13 14 15 16 17 18 19 20
// Output : 11 16 12 17 13 18 14 19 15 20
// Time complexity: O(n). Auxiliary Space: O(n).
public class InterleavingQueue {
    
    public static void main(String[] args) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.addAll(Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8}));
        Iterator<Integer> itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        interleave(queue);
        System.out.println();
        
        itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println("\n");
        
        queue = new ArrayDeque<>();
        queue.addAll(Arrays.asList(new Integer[] {1, 2, 3, 4}));
        itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        interleave(queue);
        System.out.println();
        
        itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println("\n");
        
        queue = new ArrayDeque<>();
        queue.addAll(Arrays.asList(new Integer[] {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}));
        itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        interleave(queue);
        System.out.println();
        
        itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println("\n");
        
    }
    
    // Reverse the first half of the queue.
    // Push the first half to stack.
    // Interleave by:
    // Pop from stack then enqueue to queue
    // Dequeue from queue then enqueue to queue
    public static void interleave(Queue<Integer> queue) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        int len = queue.size();  // queue.size() changes when modifying queue
        
        // 1 2 3 4 5 6 7 8
        // queue: 5 6 7 8
        // stack: 1 2 3 4 (Top)
        for (int i = 0; i < len / 2; i++) {  // push first half of queue to stack
            stack.push(queue.poll());
        }
        
        // queue: 5 6 7 8 4 3 2 1
        while (!stack.isEmpty()) {  // pop from stack then enqueue to queue
            queue.add(stack.pop());
        }
        
        // Result is the reverse of first half
        // queue: 4 3 2 1 5 6 7 8
        for (int i = 0; i < len / 2; i++) {  // dequeue then enqueue first half of queue
            queue.add(queue.poll());
        }
        
        // queue: 5 6 7 8
        // stack: 4 3 2 1 (Top)
        for (int i = 0; i < len / 2; i++) {  // push first half of queue to stack
            stack.push(queue.poll());
        }
        
        // queue: 1 5 2 6 3 7 4 8
        while (!stack.isEmpty()) {    // interleave by:
            queue.add(stack.pop());   // pop from stack then enqueue to queue
            queue.add(queue.poll());  // dequeue then enqueue to queue
        }
    }
    
}

