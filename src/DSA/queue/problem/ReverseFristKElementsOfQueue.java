package DSA.queue.problem;

import java.util.ArrayDeque;

import DSA.queue.ListQueue;

// Given an integer k and a queue of integers, we need to reverse the order of the first k elements of the queue,
// leaving the other elements in the same relative order.
// Only following standard operations are allowed on queue.
// enqueue(x) : Add an item x to rear of queue
// dequeue() : Remove an item from front of queue
// size() : Returns number of elements in queue.
// front() : Finds front item.

// Input : Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100] k = 5
// Output : Q = [50, 40, 30, 20, 10, 60, 70, 80, 90, 100]
// Input : Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100] k = 4
// Output : Q = [40, 30, 20, 10, 50, 60, 70, 80, 90, 100]

// The idea is to use an auxiliary stack.
public class ReverseFristKElementsOfQueue {
    public static void main(String[] args) {
        ListQueue<Integer> queue = new ListQueue<>();
        queue.enqueue(Integer.valueOf(10));
        queue.enqueue(Integer.valueOf(20));
        queue.enqueue(Integer.valueOf(30));
        queue.enqueue(Integer.valueOf(40));
        queue.enqueue(Integer.valueOf(50));
        queue.enqueue(Integer.valueOf(60));
        queue.enqueue(Integer.valueOf(70));
        queue.enqueue(Integer.valueOf(80));
        queue.enqueue(Integer.valueOf(90));
        queue.enqueue(Integer.valueOf(100));
        System.out.println("Input: " + queue.toString());
        reverseFirstKElements(queue, 5);
        System.out.println("Outpt: " + queue.toString());
        
        queue = new ListQueue<>();
        queue.enqueue(Integer.valueOf(10));
        queue.enqueue(Integer.valueOf(20));
        queue.enqueue(Integer.valueOf(30));
        queue.enqueue(Integer.valueOf(40));
        queue.enqueue(Integer.valueOf(50));
        queue.enqueue(Integer.valueOf(60));
        queue.enqueue(Integer.valueOf(70));
        queue.enqueue(Integer.valueOf(80));
        queue.enqueue(Integer.valueOf(90));
        queue.enqueue(Integer.valueOf(100));
        System.out.println("Input: " + queue.toString());
        reverseFirstKElements(queue, 4);
        System.out.println("Outpt: " + queue.toString());
    }
    
    // queue (1 2 3) 4 5
    // stack 1 2 3
    // queue 4 5 3 2 1 -> 3 2 1 4 5
    public static ListQueue<Integer> reverseFirstKElements(ListQueue<Integer> queue, int k) {
        
        if (queue.size() == 0 || k == 0 || k > queue.size()) {
            return queue;
        }
        
        int size = queue.size();  // get the original size
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < k; i++) {  // dequeue from queue then push to stack
            stack.push(queue.dequeue());
        }
        
        for (int i = 0; i < k; i++) {  // pop from stack then enqueue to queue
            queue.enqueue(stack.pop());
        }
                
        // Using queue.size() in for loop gives infinite loop since this queue is my own implementation.
        // The value returned by collection's .size() method would cache and recalculate only when the actual collection is modified.
        for (int i = 0; i < size - k; i++) {  // dequeue from queue then enqueue to the back of itself.
            queue.enqueue(queue.dequeue());
        }
        
        return queue;
    }
    
}
