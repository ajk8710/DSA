package DSA.dataStructure.problems;

// Given a sorted linked list, delete all nodes that have duplicate numbers (all occurrences),
// leaving only numbers that appear once in the original list.
// Input : 23->28->28->35->49->49->53->53
// Output : 23->35
// Input : 11->11->11->11->75->75
// Output : empty list
public class LinkedListRemoveDuplicates {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
    public static Node removeDuplicates(MyLinkedList list) {
        
        if (list.head() == null) {  // if list is empty
            return null;
        }
        if (list.head().next == null) {  // if list contains only one node
            return list.head;
        }
        if (list.head.data == list.tail.data) {  // if all nodes data are same
            return null;
        }
        
        // dummy is a node and dummy.next points to head
        Node dummy = new Node();
        dummy.next = list.head;
        
        // prev points to (refers to) dummy
        Node prev = dummy;
        
        // curr starts at head and is to look for the last node of duplicate
        // curr moves if curr & curr.next is duplicate (moves until finding last node of duplicates)
        Node curr = list.head;

        // prev and curr moves together if curr & curr.next is not duplicate
        
        // d-> 28->28->35->49->49->53->53
        // p   c                           // keep moving c until finding last duplicate
        // p       c                       // if p.next is not c  (they didn't move together or is not beside each other)
        // d---------->35->49->49->53->53  // p.next (which is d.next) = c.next
        // p           c                   // advance c
        // p           c                   // keep moving c until finding last duplicate
        // p           c                   // if p.next is c (they moved together or is beside each other)
        //             p   c               // advance both p and c   
        //             p       c           // keep moving c until finding last duplicate
        //             p       c           // if p.next is not c  (they didn't move together or is not beside each other)
        // d---------->35--------->53->53  // p.next = c.next
        //             p           c       // advance c
        //             p               c   // keep moving c until finding last duplicate or until curr.next is null
        //             p               c   // if p.next is not c  (they didn't move together or is not beside each other)
        // d---------->35---------------->null  // p.next = c.next
        //             p                  c     // advance c (c = p.next) and c is null so terminate

        while (curr != null) {
            while (curr.next != null && curr.data == curr.next.data) {
                curr = curr.next;  // find the last duplicate
            }
            
            if (prev.next != curr) {  // there are duplicates between prev and curr and curr is the last duplicate
                prev.next = curr.next;  // throw away duplicates by prev.next to point curr.next
                curr = curr.next;  // advance curr and run through again
            }
            else {  // prev.next is curr (prev->curr), there is no duplicate in between
                prev = prev.next;  // advance both prev and curr
                curr = curr.next;
            }
        }
        
        return dummy.next;
        
        
        // Node next = list.head().next;
        //    28->28->35->49->49->53->53
        // p   c  n
        // p   c      n
        
//        while (next.next != null) {
//            while (next != null && curr.data == next.data) {
//                next = next.next;
//                if (curr.data != next.data) {
//                    
//                }
//            }
//        }
        
 
//        if (curr.data == curr.next.data) {
//            while (curr.data == curr.next.data) {
//                curr = curr.next;
//            }
//            if (prev == null) {
//                prev = curr.next;
//            }
//            else {
//                prev.next = curr.next;
//            }
//        }
//        else {  // if data equal, move curr
//            
//        }

    }

}
