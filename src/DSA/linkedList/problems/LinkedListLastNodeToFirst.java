package DSA.linkedList.problems;

// Modify linked list so that the last node becomes the first node
// Input: head = [1,2,3,4]
// Output: [4,1,2,3]
public class LinkedListLastNodeToFirst {

    public static void main(String[] args) {
        
        MyLinkedList list = new MyLinkedList(new int[] {1,2,3,4});
        list = new MyLinkedList(lastNodeToFirst(list.head));
        list.display();
        
        list = new MyLinkedList(new int[] {1, 2});
        list = new MyLinkedList(lastNodeToFirst(list.head));
        list.display();
        
        list = new MyLinkedList(new int[] {1});
        list = new MyLinkedList(lastNodeToFirst(list.head));
        list.display();
        
        list = new MyLinkedList(new int[] {});
        list = new MyLinkedList(lastNodeToFirst(list.head));
        list.display();
        
    }

    public static Node lastNodeToFirst(Node head) {  // head is another pointer that is pointing to the same node that original head is pointing
        if (head == null || head.next == null) {
            return head;
        }
        
        Node prev = null;  // find node before tail
        Node curr = head;  // find tail
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = null;
        curr.next = head;
        head = curr;
        
        return head;
    }
    
}
