package DSA.linkedList.problems;

// Given the head of a linked list, remove the nth node from the end of the list and return its head.
// Follow up: Could you do this in one pass?
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Input: head = [1], n = 1
// Output: []
// Input: head = [1,2], n = 1
// Output: [1]
public class LinkedListRemoveNthFromEnd {

    public static void main(String[] args) {
        
        MyLinkedList list = new MyLinkedList(new int[] {1,2,3,4,5});
        list = new MyLinkedList(removeNthFromEnd(list.head, 2));
        list.display();
        
        MyLinkedList list2 = new MyLinkedList(new int[] {1});
        list2 = new MyLinkedList(removeNthFromEnd(list2.head, 1));
        list2.display();
        
        MyLinkedList list3 = new MyLinkedList(new int[] {1, 2});
        list3 = new MyLinkedList(removeNthFromEnd(list3.head, 2));
        list3.display();
        
        MyLinkedList list4 = new MyLinkedList(new int[] {1, 2});
        list4 = new MyLinkedList(removeNthFromEnd(list4.head, 1));
        list4.display();
        
    }
    
    public static Node removeNthFromEnd(Node head, int n) {  // head is another pointer that is pointing to the same node that original head is pointing
        
        int count = 0;  // number of nodes
        Node curr = head;
        while (curr != null) {  // find number of nodes
            curr = curr.next;
            count++;
        }
        
        int index = count - n;  // index from beginning
        Node prev = null;
        curr = head;
        for (int i = 0; i < index; i++) {
            prev = curr;
            curr = curr.next;
        }
        
        if (prev == null) {  // removing the first node
            head = curr.next;
        }
        else {
            prev.next = curr.next;
        }
        
        return head;
        
    }
    
}
