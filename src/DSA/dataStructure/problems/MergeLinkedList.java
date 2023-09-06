package DSA.dataStructure.problems;

// Write a function that takes two ascending linked lists, and merges the two together into one linked list which is in ascending order.
public class MergeLinkedList {

    public static void main(String[] args) {
        
        MyLinkedList l1 = new MyLinkedList(new int[] {1, 2, 3, 5, 7});
        MyLinkedList l2 = new MyLinkedList(new int[] {4, 6, 9, 11});
        l1.display();
        l2.display();
        
        MyLinkedList l3 = mergeLinkedList(l1, l2);
        l3.display();
        
        System.out.println();
        l1 = new MyLinkedList(new int[] {1, 2});
        l2 = new MyLinkedList(new int[] {4, 6, 9, 11});
        l3 = mergeLinkedList(l1, l2);
        l3.display();
        
        l1 = new MyLinkedList();
        l2 = new MyLinkedList();
        l3 = mergeLinkedList(l1, l2);
        l3.display();

    }
    
    public static MyLinkedList mergeLinkedList(MyLinkedList l1, MyLinkedList l2) {
        MyLinkedList l3 = new MyLinkedList();
        
        Node n1 = l1.head();
        Node n2 = l2.head();
        while (n1 != null && n2 != null) {  // until one or the other list reaches to end (while both not null)
            if (n1.data <= n2.data) {
                l3.append(n1.data);
                n1 = n1.next;
            }
            else {
                l3.append(n2.data);
                n2 = n2.next;
            }
        }
        
        while (n1 != null) {  // if there is left over in n1
            l3.append(n1.data);
            n1 = n1.next;
        }
        
        while (n2 != null) {  // if there is left over in n2
            l3.append(n2.data);
            n2 = n2.next;
        }
        
        return l3;
    }

}

class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
    }
}

class MyLinkedList {
    Node head;
    Node tail;
    int len = 0;
    
    public MyLinkedList() {
        
    }
    
    public MyLinkedList(int[] initialData) {
        for (int i : initialData) {
            this.append(i);
        }
    }
    
    public void append(int data) {
        Node node = new Node(data);
        
        if (head == null) {  // if empty list
            head = node;     // head points to new node
            tail = node;     // tail points to new node
        }
        else {                 // if not empty set
            tail.next = node;  // tail's next points to new node
            tail = node;       // new node is now tail
        }
        len++;
    }
    
    public void insert(int data) {
        Node newNode = new Node(data);
        
        Node prev = null;
        Node curr = head;
        
        if (len == 0) {  // if empty list
            head = newNode;
            tail = newNode;
            len++;
            return;
        }
        
        while (curr != null && newNode.data > curr.data) {  // traverse pointers
            prev = curr;
            curr = curr.next;
        }
        
        if (prev == null) {  // inserting at the beginning
            newNode.next = curr;
            head = newNode;
        }
        else if (curr == null) {  // inserting at the end
            tail.next = newNode;
            tail = newNode;
        }
        else {
            newNode.next = curr;
            prev.next = newNode;
        }
        len++;
    }
    
    public void display() {
        Node curr = head;  // use curr, not head. head is not to be updated.
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    
    public int len() {
        return len;
    }
    
    public Node head() {
        return head;
    }
    
}
