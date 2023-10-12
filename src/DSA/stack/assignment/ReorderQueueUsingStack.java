package DSA.stack.assignment;

import DSA.queue.ArrayQueue;

/*
Given a Queue consisting of first n natural numbers (1, 2, 3, 4, 5... in random order).
The task is to check whether the given Queue elements can be arranged in increasing order in another Queue using a stack.
The operation allowed are:
1. Push and pop elements from the stack
2. Pop (Or enqueue) from the given Queue.
3. Push (Or Dequeue) in the another Queue.
4. Peek last on stack and peek first on queue.

Examples :
Input : Queue[] = { 5, 1, 2, 3, 4 }
Output : Yes
Pop the first element of the given Queue i.e 5.
Push 5 into the stack.
Now, pop all the elements of the given Queue and push them to second Queue.
Now, pop element 5 in the stack and push it to the second Queue.

Input : Queue[] = { 5, 1, 2, 6, 3, 4 }
Output : No
*/
public class ReorderQueueUsingStack {
    
    // Initialize integer inOrder as 1.
    // While queue.peek == inOrder: enqueue to newQueue. inOrder++.
    // Otherwise: push non in-order item to stack.
    // When pushing to stack, If top of stack is smaller than front of queue: return false.
    // (stack must pop smaller then to larger, in order to enqueue back in order)
    public static boolean canReorderQueueInOrder(ArrayQueue<Integer> queue) {
        ArrayStackForInt stack = new ArrayStackForInt();
        ArrayQueue<Integer> newQueue = new ArrayQueue<>(queue.size());
        int inOrder = 1;  // the first item is 1 if in order
        
        while (queue.size() != 0) {  // while queue not empty
            while (queue.size() != 0 && queue.peek() == inOrder) {  // short circuit
                newQueue.enqueue(queue.dequeue());  // if in-order item, dequeue then enqueue to new queue
                inOrder++;
            }
            
            if (queue.size() != 0) {  // to make sure not to dequeue from empty queue
                if (stack.len() == 0) {  // if stack empty, push the first non in-order item
                    stack.push(queue.dequeue());
                }
                else {  // if stack not empty
                    if (stack.peek() < queue.peek()) {  // stack must be pushed larger first ... then smaller
                        return false;                   // to pop and enqueue back to queue smaller ... larger
                    }
                    stack.push(queue.dequeue());
                }
            }

        }
        
        while(stack.len() != 0) {  // pop from stack then enqueue to newStack, to display newStack for test purpose
            newQueue.enqueue(stack.pop());
        }
        newQueue.display();
        return true;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(5);  // stack: 5
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println("{ 5, 1, 2, 3, 4 }");
        System.out.println(canReorderQueueInOrder(queue));
        System.out.println();
        
        queue = new ArrayQueue<>(6);
        queue.enqueue(5);  // stack: 5
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(6);  // 6 greater than 5 - false
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println("{ 5, 1, 2, 6, 3, 4 }");
        System.out.println(canReorderQueueInOrder(queue));
        System.out.println();
        
        queue = new ArrayQueue<>(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        System.out.println("{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }");
        System.out.println(canReorderQueueInOrder(queue));
        System.out.println();
        
        queue = new ArrayQueue<>(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(10);  // stack: 10
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        System.out.println("{ 1, 2, 3, 10, 4, 5, 7, 6, 8, 9 }");
        System.out.println(canReorderQueueInOrder(queue));
        System.out.println();
        
        queue = new ArrayQueue<>(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(9);  // stack: 9
        queue.enqueue(7);  // stack: 9 7
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(8);   // 8 greater than 7 - false
        queue.enqueue(10);
        System.out.println("{ 1, 2, 3, 9, 7, 4, 5, 6, 8, 10 }");
        System.out.println(canReorderQueueInOrder(queue));
        System.out.println();
    }
}
