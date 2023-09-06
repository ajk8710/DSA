package DSA.dataStructure.problems;

// Display alternative numbers of linked list.
// L = [0, 11, 21, 13, 4, 15, 63 ,75, 84, 92]
// 11, 13 ,15, 75, 92
// 0, 21, 4, 63, 84
public class LinkedListAlternativeTraverse {

    public static void main(String[] args) {
        
        MyLinkedList list = new MyLinkedList(new int[] {0, 11, 21, 13, 4, 15, 63 ,75, 84, 92});
        list.display();
        displayAlternative(list);
        
        MyLinkedList list2 = new MyLinkedList();
        list2.display();
        displayAlternative(list2);
        
        MyLinkedList list3 = new MyLinkedList(new int[] {0, 11, 21, 13, 4, 15, 63 ,75, 84});
        list3.display();
        displayAlternative(list3);

    }
    
    public static void displayAlternative(MyLinkedList list) {
        Node n1 = list.head();      // n1 is the first node (head)
        
        Node n2 = null;             // n2 is the second node (head.next)
        if (list.head() != null) {
            n2 = list.head().next;
        }
        
        while (n2 != null) {        // print the value of n2 and move to next.next
            System.out.print(n2.data + " ");
            n2 = n2.next;  // n2 may be null at this point
            if (n2 != null) {
                n2 = n2.next;
            }
        }
        System.out.println();
        
        while (n1 != null) {        // print the value of n1 and move to next.next
            System.out.print(n1.data + " ");
            n1 = n1.next;  // n2 may be null at this point
            if (n1 != null) {
                n1 = n1.next;
            }
        }
        System.out.println();
    }

}
