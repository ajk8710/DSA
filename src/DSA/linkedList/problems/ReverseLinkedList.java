package DSA.linkedList.problems;

// Reverse Linked List.
// Print both original and reversed.
public class ReverseLinkedList {
    
    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList(new int[] {1, 2, 3, 3, 4, 5});
        Node newHead = reverseLinkedList(list1.head);
        MyLinkedList list1Reversed = new MyLinkedList(newHead);
        list1.display();
        list1Reversed.display();
        
        MyLinkedList list2 = new MyLinkedList(new int[] {});
        Node newHead2 = reverseLinkedList(list2.head);
        MyLinkedList list1Reversed2 = new MyLinkedList(newHead2);
        list2.display();
        list1Reversed2.display();
        
        MyLinkedList list3 = new MyLinkedList(new int[] {1});
        Node newHead3 = reverseLinkedList(list3.head);
        MyLinkedList list1Reversed3 = new MyLinkedList(newHead3);
        list3.display();
        list1Reversed3.display();
    }
    
    public static Node reverseLinkedList(Node head) {
        MyLinkedList rv = new MyLinkedList();
        Node node = head;
        while (node != null) {
            rv.append(node.data);
            node = node.next;
        }

        Node prev = null;
        Node curr = rv.head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
    
}
