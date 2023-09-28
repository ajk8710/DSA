package DSA.linkedList.assessment;

/*
You are given the head of a sorted singly linked list.
Each segment (contiguous collection of nodes) consists of the same value nodes.
You can delete all nodes in a segment if the count of nodes in a segment is odd.
You need to delete the maximum possible nodes and keep the remaining nodes in the same order.

Print the head of the resulting linked list.
N=9
And the linked list 1 -> 1 -> 2 -> 2 -> 2 -> 3 -> 4 -> 4 -> 5
Here, the minimum possible segments are 5.
Seg1 = [1, 1]
Seg2 = [2, 2, 2]
Seg3 = [3]
Seg4 = [4, 4]
Seg5 = [5]

We can delete all nodes in the Seg2, Seg3 and Seg5.
linked list output will be 1 -> 1 -> 4 -> 4
*/

public class RemoveOddSegmentsOfLinkedList {
    
    public static void main(String args[]) {
        MyLinkedList list = new MyLinkedList(new int[] {1, 1, 2, 2, 2, 3, 4, 4, 5});
        System.out.println("{1, 1, 2, 2, 2, 3, 4, 4, 5}: ");
        new MyLinkedList(removeOddSegments(list.head)).display();
        
        list = new MyLinkedList(new int[] {1, 1, 2, 2, 2, 3});
        System.out.println("{1, 1, 2, 2, 2, 3}: ");
        new MyLinkedList(removeOddSegments(list.head)).display();
        
        list = new MyLinkedList(new int[] {1});
        System.out.println("{1}: ");
        new MyLinkedList(removeOddSegments(list.head)).display();
        
        list = new MyLinkedList(new int[] {1, 1});
        System.out.println("{1, 1}: ");
        new MyLinkedList(removeOddSegments(list.head)).display();
        
        list = new MyLinkedList(new int[] {1, 1, 1});
        System.out.println("{1, 1, 1}: ");
        new MyLinkedList(removeOddSegments(list.head)).display();
        
        list = new MyLinkedList(new int[] {1, 2});
        System.out.println("{1, 2}: ");
        new MyLinkedList(removeOddSegments(list.head)).display();
        
        list = new MyLinkedList(new int[] {1, 2, 3});
        System.out.println("{1, 2, 3, 4, 5}: ");
        new MyLinkedList(removeOddSegments(list.head)).display();
        
        list = new MyLinkedList(new int[] {1, 2, 3, 3});
        System.out.println("{1, 2, 3, 3}: ");
        new MyLinkedList(removeOddSegments(list.head)).display();
    }
    
    public static Node removeOddSegments(Node head) {
        
        Node dummy = new Node();
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;
        
        // d 1 1 2 2 2 3 4 4 5
        //             c
        //     p
        //   1 1         4
        
        // d 1 2 3 3
        //           c
        //       p
        //       3
        while (curr != null) {
            int count = 1;
            while (curr.next != null && curr.data == curr.next.data) {  // advance curr for segment
                count++;
                curr = curr.next;
            }
            if (prev != null && count % 2 == 1) {  // if odd
                prev.next = curr.next;             // skip over duplicates
                curr = curr.next;                  // advance curr only
            }
            else {                                 // if not odd
                prev = curr;                       // advance prev & curr
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }

}
