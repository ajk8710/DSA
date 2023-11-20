package DSA.linkedList.assessment;

// You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit. 
// Add the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807
public class AddTwoNumsRepresentedByLinkedLists {
    
    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList(new int[] {2, 4, 3, 2, 2});
        MyLinkedList list2 = new MyLinkedList(new int[] {5, 6, 4});
        addTwoNums(list1.head, list2.head);
        System.out.println();
        
        list1 = new MyLinkedList(new int[] {9, 9, 9, 9 ,9 ,9 ,9});
        list2 = new MyLinkedList(new int[] {9, 9, 9, 9});
        addTwoNums(list1.head, list2.head);
        System.out.println();
    }
    
    // While l1, l2 not null, add values.
    // If there is carry over, flag carry over. Make sure to add 1 when summing next digits. Utilize modulus when calculating.
    // Edge Case 1: If one list has more digits than the other. Just append leftovers while keeping track of carry.
    // Edge Case 2: When last digit ends up with carry. Append 1 at the end.
    public static Node addTwoNums(Node l1, Node l2) {
        
        boolean carryOver = false;  // could use carryOver as integer 0 and 1. Then add it as well it while doing sum.
        
        Node ptr1 = l1;
        Node ptr2 = l2;
        // dummy let us do same operation whether it's first node or second & beyond nodes:
        // Just create node with summation and set it to curr.next
        Node dummy = new Node();
        Node curr = dummy;
        while (ptr1 != null & ptr2 != null) {  // could do "or" (not "and"), then set digit as 0 when one of ptr is null
            int sum = ptr1.data + ptr2.data;  // add two digits
            
            // handle carry over
            if (carryOver) {
                sum += 1;
            }
            
            if (sum >= 10) {
                sum = sum % 10;
                carryOver = true;
            }
            else {
                carryOver = false;
            }
            // handle carry over - ends
            
            curr.next = new Node(sum);
            curr = curr.next;
            
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        while (ptr1 != null) {  // handle left over on one of list
            int digit = ptr1.data;
            // handle carry over
            if (carryOver) {
                digit += 1;
            }
            
            if (digit >= 10) {
                digit = digit % 10;
                carryOver = true;
            }
            else {
                carryOver = false;
            }
            // handle carry over - ends
            
            curr.next = new Node(digit);
            curr = curr.next;
            ptr1 = ptr1.next;
        }
        
        while (ptr2 != null) {  // handle left over on one of list
            int digit = ptr2.data;
            // handle carry over
            if (carryOver) {
                digit += 1;
            }
            
            if (digit >= 10) {
                digit = digit % 10;
                carryOver = true;
            }
            else {
                carryOver = false;
            }
            // handle carry over - ends
            
            curr.next = new Node(digit);
            curr = curr.next;
            ptr2 = ptr2.next;
        }
        
        if (carryOver) {  // if there is carry over in the end
            curr.next = new Node(1);
        }
        
        curr = dummy.next;  // print to test
        while (curr != null) {
            System.out.print(curr.data);
            curr = curr.next;
        }
        
        return dummy.next;
    }
    
}
