package DSA.stack.problems;

import java.util.ArrayDeque;
import java.util.Collections;

/*
Stack: Stacking Actions

You are given a set of N actions.
To process the N actions, you initialize an empty stack S.
Each action is characterized by an integer.

If the integer associated with an action is anything but -1, you insert that integer into the stack S and print 0. 
That particular action is then completed.

If the integer associated with an action is -1,
then you need to remove all the elements above the minimum element in the stack,
including the minimum element, and print the number of elements removed.
If there are multiple elements in the stack with the same minimum value,
you should consider the topmost minimum elements as the minimum.

Consider, for example, the number of actions N = 6.
The actions in order given as [9, 6, 8, -1, 3, -1].
Then, for the first three actions, we insert elements 9, 6, and 8 into the stack.
We print three 0s for these actions.
The stack becomes [8, 6, 9]. The next action is -1.
For this action, we remove elements 8 and 6 from the stack and print 2.
The stack now becomes [9].  For the next action, we insert 3 into the stack and print 0.
The stack now becomes [3, 9]. For the final action, we remove three the stack and print 1.
Hence, the answer is 0, 0, 0, 2, 0, 1.
*/
public class StackActionsWhileKeepingMin {
    
    public static void stackActions(int[] arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int min = -1;
        
        for (int i : arr) {
            if (i != -1) {  // for anything other than -1
                if (min == -1) {
                    min = i;  // initialize min as first element that is not -1
                }
                // min = Math.min(i, min);  // updates min - It only keeps up with latest minimum. Instead of updating min here, find min at else condition.
                stack.addLast(i);  // add i to stack & print 0
                System.out.print(0 + " ");
            }
            else {  // if -1
                int count = 0;
                min = Collections.min(stack);
                while (!stack.isEmpty() && stack.peekLast() != min) {  // while not min, poll
                    stack.pollLast();
                    count++;
                }
                stack.pollLast();  // poll min
                count++;
                System.out.print(count + " ");  // how to efficiently update new min once old min is removed??? (new min is min amoung what's left in stack)
                // Solution: Instead of updating minimum while going through array, find minimum when you need it (when you see -1).
            }
            System.out.println(stack);  // print stack for testing
        }
    }
    
    public static void main(String[] args) {
        stackActions(new int[] {9, 6, 8, -1, 3, -1});
        System.out.println();
        stackActions(new int[] {9, 6, 8, -1, 10, -1});
        System.out.println();
        stackActions(new int[] {9, 7, 6, 8, -1, 8, -1});
    }
}
