package DSA.linkedList.assessment;

// Reverse a Linked List in groups of given size. 
// Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.
//
// Input: LinkedList: 1->2->2->4->5->6->7->8, K = 4
// Output: 4 2 2 1 8 7 6 5
//
// Input: LinkedList: 1->2->3->4->5, K = 3
// Output: 3 2 1 4 5
public class ReverseListFromNth {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public static Node reverseListFromNth(Node head, int n) {
        
        // d  1  2  3  4 
        // c  t
        Node dummy = new Node();
        dummy.next = head;
        Node curr = dummy;
        
        for (int i = 0; i < n; i++) {
            Node temp = curr;
            curr = curr.next;
        }
        return null;
    }

}
