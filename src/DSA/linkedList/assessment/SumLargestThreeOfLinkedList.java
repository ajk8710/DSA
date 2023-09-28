package DSA.linkedList.assessment;

// A Linked List containing N element is given.
// Print the sum of highest three elements of the Linked List.
// eg:N = 6 
// Linked list = > 1->6->4->3->5->2
// output will be = 6 + 5 + 4 =15.
public class SumLargestThreeOfLinkedList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(new int[] {3});
        System.out.println("{3}: " + SumLargestThree(list.head));
        
        list = new MyLinkedList(new int[] {3, 1});
        System.out.println("{3, 1}: " + SumLargestThree(list.head));
        
        list = new MyLinkedList(new int[] {3, 1, 5});
        System.out.println("{3, 1, 5}: " + SumLargestThree(list.head));
        
        list = new MyLinkedList(new int[] {3, 1, 5, 1});
        System.out.println("{3, 1, 5, 1}: " + SumLargestThree(list.head));
        
        list = new MyLinkedList(new int[] {3, 1, 5 , -1});
        System.out.println("{3, 1, 5 , -1}: " + SumLargestThree(list.head));

        list = new MyLinkedList(new int[] {1, 6, 4, 3, 5, 2});
        System.out.println("{1, 6, 4, 3, 5, 2}: " + SumLargestThree(list.head));

    }
    
    public static int SumLargestThree(Node node) {
        
        if (node == null) {
            return 0;
        }
        
        if (node.next == null) {
            return node.data;
        }
        
        if (node.next.next == null) {
            return node.data + node.next.data;
        }
        
        if (node.next.next.next == null) {
            return node.data + node.next.data + node.next.next.data;
        }
        
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        
        Node curr = node;
        
        while (curr != null) {
            if (curr.data >= first) {
                third = second;
                second = first;
                first = curr.data;
            }
            else if (curr.data >= second) {
                third = second;
                second = curr.data;
            }
            else if (curr.data >= third) {
                third = curr.data;
            }
            
            curr = curr.next;
        }

        return first + second + third;
    }

}
