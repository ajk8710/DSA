package DSA.linkedList.problems;

// Given a sorted linked list, delete all duplicates, leaving only distinct numbers.
// Input : 23->28->28->35->49->49->53->53
// Output : 23->28->35->49->53
// Input : 11->11->11->11->75->75
// Output : 11->75
public class LinkedListRemoveDuplicatesButDistinct {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(new int[] {23, 28, 28, 35, 49, 49, 53, 53});
        Node n1 = removeDuplicatesButDistinct(list);
        list = new MyLinkedList(n1);
        list.display();
        
        MyLinkedList list2 = new MyLinkedList(new int[] {28, 28, 35, 49, 49, 53, 53});
        Node n2 = removeDuplicatesButDistinct(list2);
        list2 = new MyLinkedList(n2);
        list2.display();
        
        MyLinkedList list3 = new MyLinkedList(new int[] {11, 11, 11, 11, 75, 75});
        Node n3 = removeDuplicatesButDistinct(list3);
        list3 = new MyLinkedList(n3);
        list3.display();
        
        MyLinkedList list4 = new MyLinkedList(new int[] {1, 2, 3});
        Node n4 = removeDuplicatesButDistinct(list4);
        list4 = new MyLinkedList(n4);
        list4.display();
        
        MyLinkedList list5 = new MyLinkedList(new int[] {4, 4, 4, 4, 6, 8, 10, 12, 12});
        Node n5 = removeDuplicatesButDistinct(list5);
        list5 = new MyLinkedList(n5);
        list5.display();
    }
    
    public static Node removeDuplicatesButDistinct(MyLinkedList list) {
        
        Node head = list.head;
        
        if (head == null) {  // if list is empty
            return null;
        }
        
        // 23->28->28->28->35->49->49->53->53
        // p   c                               // p & c advance together if p.data != c.data
        // 23->28->28->28->35->49->49->53->53
        //     p   c
        //     p       c                       // c alone advances while p.data == c.data
        //     p           c
        // 23->28--------->35->49->49->53->53  // p.next = curr
        //                 p   c
        //                 p       c
        //                 p           c
        // 23->28--------->35->49----->53->53
        //                             p   c
        //                             p       c
        // 23->28--------->35->49----->53---->null
        
        Node prev = head;
        Node curr = head.next;
        
        while (curr != null) {
            while (curr != null && prev.data == curr.data) {  // find the last curr that is same as prev
                curr = curr.next;
            }                                 // skip over the last duplicate
            prev.next = curr;
            prev = curr;
            if (curr != null) {
                curr = curr.next;
            }
        }
        
        return head;

    }

}
