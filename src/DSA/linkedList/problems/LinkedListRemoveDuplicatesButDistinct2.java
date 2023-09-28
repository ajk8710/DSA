package DSA.linkedList.problems;

//Given a sorted linked list, delete all duplicates, leaving only distinct numbers.
//Input : 23->28->28->35->49->49->53->53
//Output : 23->28->35->49->53
//Input : 11->11->11->11->75->75
//Output : 11->75
public class LinkedListRemoveDuplicatesButDistinct2 {
    
    public static void main(String args[]) {
        MyLinkedList list = new MyLinkedList(new int[] {1, 1, 2, 2, 2, 3, 4, 4, 5});
        System.out.println("{1, 1, 2, 2, 2, 3, 4, 4, 5}: ");
        new MyLinkedList(removeDuplicatesButDistinct(list.head)).display();
        
        list = new MyLinkedList(new int[] {23, 28, 28, 35, 49, 49, 53, 53});
        System.out.println("{23, 28, 28, 35, 49, 49, 53, 53}: ");
        new MyLinkedList(removeDuplicatesButDistinct(list.head)).display();
        
        list = new MyLinkedList(new int[] {28, 28, 35, 49, 49, 53, 53});
        System.out.println("{28, 28, 35, 49, 49, 53, 53}: ");
        new MyLinkedList(removeDuplicatesButDistinct(list.head)).display();
        
        list = new MyLinkedList(new int[] {11, 11, 11, 11, 75, 75});
        System.out.println("{11, 11, 11, 11, 75, 75}: ");
        new MyLinkedList(removeDuplicatesButDistinct(list.head)).display();
        
        list = new MyLinkedList(new int[] {1, 2, 3});
        System.out.println("{1, 2, 3}: ");
        new MyLinkedList(removeDuplicatesButDistinct(list.head)).display();
        
        list = new MyLinkedList(new int[] {1});
        System.out.println("{1}: ");
        new MyLinkedList(removeDuplicatesButDistinct(list.head)).display();
        
        list = new MyLinkedList(new int[] {1, 1});
        System.out.println("{1, 1}: ");
        new MyLinkedList(removeDuplicatesButDistinct(list.head)).display();
        
        list = new MyLinkedList(new int[] {});
        System.out.println("{}: ");
        new MyLinkedList(removeDuplicatesButDistinct(list.head)).display();
    }
    
    public static Node removeDuplicatesButDistinct(Node head) {
        
        Node dummy = new Node();
        dummy.next = head;  // If head == null, returns head. If head.next == null, returns head
        Node prev = head;
        Node curr = head;
        
        // d 1 1 2 2 2 3 4 4 5
        //           c 
        //       p
        //   1   2
        while (curr != null) {
            while (curr.next != null && curr.data == curr.next.data) {
                curr = curr.next;
            }
            if (prev != null) {
                prev.next = curr.next;
            }
            prev = curr.next;
            curr = curr.next;
        }

        return dummy.next;
    }

}
