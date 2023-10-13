package DSA.stack.problems;

import java.util.EmptyStackException;

/*
You are given a stack data structure with push and pop operations,
the task is to implement a queue using instances of stack data structure and operations on them.
enQueue(q, x)
  1) Push x to stack1 (assuming size of stacks is unlimited).
  Here time complexity will be O(1)
deQueue(q)
  1) If both stacks are empty then error.
  2) If stack2 is empty
       While stack1 is not empty, push everything from stack1 to stack2.
  3) Pop the element from stack2 and return it.
  Here time complexity will be O(n)
*/
public class QueueImplementedWithStacks {
    public static void main(String[] args) {
        QueueImplementedByStacks queue = new QueueImplementedByStacks();
        queue.enqueue('1');
        queue.enqueue('2');
        queue.enqueue('3');
        queue.enqueue('4');
        queue.enqueue('5');
        queue.display();     // Top 5 4 3 2 1
        System.out.println("\ndequeue-ing: ");
        queue.dequeue();     // pop and push all to stack2
        queue.display();     // Top (1) 2 3 4 5
        queue.dequeue();     // pop from stack2
        queue.display();     // Top (2) 3 4 5
        System.out.println("\nenqueue-ing: ");
        queue.enqueue('6');
        queue.enqueue('7');
        queue.enqueue('8');
        queue.display();
        System.out.println("\ndequeue-ing: ");
        queue.dequeue();
        queue.display();
        System.out.println();
        queue.dequeue();
        queue.display();
        System.out.println();
        queue.dequeue();
        queue.display();
        System.out.println();
        queue.dequeue();
        queue.display();
    }

}

// Stack1 for enqueue. Stack2 for dequeue.
// When enqueue, push to stack1.
// When dequeue, check if stack2 is empty.
// Only when stack2 is empty, pop and push all from stack1 to stack2.
// Pop from stack2.
class QueueImplementedByStacks {
    ListStack stack1 = new ListStack();  // stack for enqueue
    ListStack stack2 = new ListStack();  // stack for dequeue
    
    void enqueue(char ch) {  // always enqueue to stack1
        stack1.push(ch);
    }
    
    char dequeue() {  // when dequeue is called
        if (stack1.len() == 0 && stack2.len() == 0 ) {
            throw new EmptyStackException();
        }
        if (stack2.len() == 0) {         // if stack2 is empty
            while (stack1.len() != 0) {  // pop everything from stack1 & push to stack2
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.pop();  // pop from stack2
    }
    
    void display() {
        System.out.print("Stack1: ");
        stack1.display();
        System.out.print("Stack2: ");
        stack2.display();
    }
    
}