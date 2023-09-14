package DSA.linkedList.assessment;

// 1) Given two unsorted Linked List, the task is to merge them to get a sorted singly linked list.
// Input: List 1 = 3 -> 1 -> 5, List 2 = 6-> 2 -> 4
// Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6
// Input: List 1 = 4 -> 7 -> 5, List 2 = 2-> 1 -> 8 -> 1
// Output: 1 -> 1 -> 2 -> 4 -> 5 -> 7 -> 8
public class MergeTwoUnsortedListsToSortedList {

    public static void main(String[] args) {
        
        MyLinkedList list1 = new MyLinkedList(new int[] {3, 1, 5});
        MyLinkedList list2 = new MyLinkedList(new int[] {6, 2, 4});
        MyLinkedList mergedSortedList = new MyLinkedList(mergeTwoUnsortedListToSortedList(list1.head, list2.head));
        mergedSortedList.display();
        
        list1 = new MyLinkedList(new int[] {6, 2, 4});
        list2 = new MyLinkedList(new int[] {3, 1, 5});
        mergedSortedList = new MyLinkedList(mergeTwoUnsortedListToSortedList(list1.head, list2.head));
        mergedSortedList.display();
        
        list1 = new MyLinkedList(new int[] {4, 7, 5});
        list2 = new MyLinkedList(new int[] {2, 1, 8, 1});
        mergedSortedList = new MyLinkedList(mergeTwoUnsortedListToSortedList(list1.head, list2.head));
        mergedSortedList.display();
        
        list1 = new MyLinkedList(new int[] {2, 2, 7});
        list2 = new MyLinkedList(new int[] {3, 1, 5, 0});
        mergedSortedList = new MyLinkedList(mergeTwoUnsortedListToSortedList(list1.head, list2.head));
        mergedSortedList.display();
        
        list1 = new MyLinkedList(new int[] {2, 2, 7, 9, -1});
        list2 = new MyLinkedList(new int[] {3, 1, 5, 0});
        mergedSortedList = new MyLinkedList(mergeTwoUnsortedListToSortedList(list1.head, list2.head));
        mergedSortedList.display();
        
        list1 = new MyLinkedList(new int[] {});
        list2 = new MyLinkedList(new int[] {});
        mergedSortedList = new MyLinkedList(mergeTwoUnsortedListToSortedList(list1.head, list2.head));
        mergedSortedList.display();
        
        list1 = new MyLinkedList(new int[] {1});
        list2 = new MyLinkedList(new int[] {});
        mergedSortedList = new MyLinkedList(mergeTwoUnsortedListToSortedList(list1.head, list2.head));
        mergedSortedList.display();
        
        list1 = new MyLinkedList(new int[] {});
        list2 = new MyLinkedList(new int[] {1});
        mergedSortedList = new MyLinkedList(mergeTwoUnsortedListToSortedList(list1.head, list2.head));
        mergedSortedList.display();
    }
    
    // Take each node from list and insert in appropriate spot in resulting list.
    // Take smaller between two lists to traverse less.
    public static Node mergeTwoUnsortedListToSortedList(Node head1, Node head2) {
        
        Node curr1 = head1;
        Node curr2 = head2;
        Node newNode = null;
        Node dummy = new Node();  // dummy.next always points to new head. Need dummy because new head will keep changing.
        
        while (curr1 != null && curr2 != null) {  // until one of lists gets to end
            if (curr1.data <= curr2.data) {       // find smaller between two lists
                newNode = new Node(curr1.data);
                curr1 = curr1.next;
            }
            else {
                newNode = new Node(curr2.data);
                curr2 = curr2.next;
            }
            
            Node ptr = dummy;  // find appropriate spot in resulting array and insert
            while (ptr.next != null && ptr.next.data <= newNode.data) {
                ptr = ptr.next;
            }
            Node temp = ptr.next;
            ptr.next = newNode;
            newNode.next = temp;
        }
        
        while (curr1 != null) {  // repeat previous process if there are left over from list1
            newNode = new Node(curr1.data);
            curr1 = curr1.next;
            Node ptr = dummy;
            while (ptr.next != null && ptr.next.data <= newNode.data) {
                ptr = ptr.next;
            }
            Node temp = ptr.next;
            ptr.next = newNode;
            newNode.next = temp;
        }
        
        while (curr2 != null) {  // repeat previous process if there are left over from list2
            newNode = new Node(curr2.data);
            curr2 = curr2.next;
            Node ptr = dummy;
            while (ptr.next != null && ptr.next.data <= newNode.data) {
                ptr = ptr.next;
            }
            Node temp = ptr.next;
            ptr.next = newNode;
            newNode.next = temp;
        }
        
        return dummy.next;
        
        /*
        // Was going for taking minimum of each, compare two, then append to resulting list.
        // But this way is complex and not even correct. Second minimum from list1 could be smaller than minimum from list2. 
        MyLinkedList returnList = new MyLinkedList();
        
        Node dum1 = new Node();  // dummy node to keep track of first list
        Node dum2 = new Node();  // dummy node to keep track of second list
        dum1.next = head1;
        dum2.next = head2;
        
        Node cur1 = dum1;
        Node cur2 = dum2;
        
        int min1 = head1.data; // 3
        int min2 = head2.data; // 6
        
        while (cur1.next != null) {
            
            Node beforeDelete = null;
            Node toDelete = null;
            
            while (cur1.next != null) {  // find min in list1
                if (cur1.next.data <= min1) {
                    min1 = cur1.next.data;
                    beforeDelete = cur1;
                    toDelete = cur1.next;
                }
                cur1 = cur1.next;
            }
            System.out.println(min1);
            beforeDelete.next = toDelete.next;
            cur1 = dum1;
        }
        
        return null;
        */
    }
    
}
