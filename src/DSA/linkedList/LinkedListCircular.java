package DSA.linkedList;

public class LinkedListCircular {
    
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insertSorted(3);
        list.display();
        list.insertSorted(5);
        list.display();
        list.insertSorted(2);
        list.display();
        list.insertSorted(1);
        list.display();
        list.insertSorted(4);
        list.display();
        
        list = new CircularLinkedList();
        list.display();
        list.insertSorted(3);
        list.display();
        list.insertSorted(2);
        list.display();
        list.insertSorted(2);
        list.display();
        list.insertSorted(4);
        list.display();
        list.insertSorted(1);
        list.display();
        
        list = new CircularLinkedList();
        list.display();
        list.insert(0, 1);  // insert(pos, val)
        list.display();
        list.insert(0, -1);
        list.display();
        list.insert(1, 3);
        list.display();
        list.insert(1, 2);
        list.display();
        list.insert(4, 5);
        list.display();
    }
    
}

class Node2 {
    int val;
    Node2 next;
    
    public Node2() {
    }
    
    public Node2(int val) {
        this.val = val;
    }
    
    public Node2(int val, Node2 next) {
        this.val = val;
        this.next = next;
    }
}

class CircularLinkedList {
    Node2 head;
    Node2 tail;
    
    public CircularLinkedList() {
    }
    
    public CircularLinkedList(Node2 head) {
        this.head = head;
        
        Node2 curr = head;
        while (curr.next != head) {  // find tail of passed list
            curr = curr.next;
        }
        this.tail = curr;
    }
    
    public void append(int val) {
        Node2 newNode =  new Node2(val);
        if (head == null) {  // if list was empty
            head = newNode;
        }
        else {
            tail.next = newNode;  // append at end
            newNode.next = head;
        }
        tail = newNode;
    }
    
    public void insertSorted(int val) {
        Node2 newNode =  new Node2(val);
        
        if (head == null) {  // if list was empty
            head = newNode;
            tail = newNode;
            return;
        }
        
        if (head == tail) {  // if list had only one node
            if (newNode.val <= head.val) {
                newNode.next = head;
                head.next = newNode;
                head = newNode;
            }
            else {
                head.next = newNode;
                newNode.next = head;
                tail = newNode;
            }
            return;
        }
        
        Node2 prev = null;
        Node2 curr = head;
        while (curr != tail && newNode.val > curr.val) {  // find position of new node
            prev = curr;
            curr = curr.next;
        }
        
        if (prev == null) {  // insert at beginning
            newNode.next = head;
            head = newNode;
        }
        else if (curr == tail) {  // insert after or before tail
            if (newNode.val > curr.val) {  // insert after tail
                curr.next = newNode;
                newNode.next = head;
                tail = newNode;
            }
            else {
                prev.next = newNode;       // insert before tail
                newNode.next = curr;
            }
        }
        else {
            prev.next = newNode;           // insert between nodes
            newNode.next = curr;
        }
    }
    
    public void insert(int pos, int val) {
        Node2 newNode =  new Node2(val);
        
        if (head == null) {  // if list was empty
            head = newNode;
            tail = newNode;
            return;
        }

        if (pos <= 0) {  // insert at beginning
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
            return;
        }
        
        if (head == tail) {  // list had only one node (and pos > 0)
            head.next = newNode;
            newNode.next = head;
            tail = newNode;
            return;
        }
        
        // at this point list must had at least two nodes
        // 1 2 3
        // p c
        Node2 prev = head;
        Node2 curr = head.next;
        for (int i = 1; i < pos; i++) {  // find position of new node
            prev = curr;
            curr = curr.next;
            if (curr == head) {
                tail = newNode;
                break;
            }
        }
        
        prev.next = newNode;  // insert between nodes
        newNode.next = curr;
    }
    
    public void display() {
        if (head == null) {
            System.out.println();
            return;
        }
        
        Node2 curr = head;
        while (curr != tail) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println(curr.val + " ");
    }
    
}