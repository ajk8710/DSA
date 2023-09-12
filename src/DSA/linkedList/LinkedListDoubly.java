package DSA.linkedList;

public class LinkedListDoubly {
    
    public static void main(String args[]) {
        
        DoublyLinkedList list1 = new DoublyLinkedList(new int[] {1, 2, 3, 3, 4, 5});
        list1.display();
        list1.displayReverse();
        
        list1.append(6);
        list1.insert(0);
        list1.insert(7);
        list1.insert(3);
        list1.display();
        list1.displayReverse();
        
        list1.delete(-1);
        list1.delete(0);
        list1.delete(7);
        list1.delete(3);
        list1.display();
        list1.displayReverse();
        
    }
    
}

class DoublyNode {
    int val;
    DoublyNode prev;
    DoublyNode next;
    
    DoublyNode() {
    }
    
    DoublyNode(int val) {
        this.val = val;
    }
    
    DoublyNode(int val, DoublyNode prev, DoublyNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    
    public DoublyLinkedList() {
    }
    
    public DoublyLinkedList(DoublyNode head) {
        this.head = head;
        DoublyNode curr = head;
        while (curr != null && curr.next != null) {  // find a tail to set
            curr = curr.next;
        }
        this.tail = curr;
    }
    
    public DoublyLinkedList(int[] initialValues) {
        for (int i : initialValues) {
            this.append(i);
        }
    }
    
    public void append(int val) {
        DoublyNode newNode = new DoublyNode(val);
        
        if (head == null) {  // if empty list, set head & tail
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    
    public void insert(int val) {
        DoublyNode newNode = new DoublyNode(val);
        
        if (head == null) {  // if empty list, set head & tail
            head = newNode;
            tail = newNode;
            return;
        }
        
        DoublyNode prev = null;
        DoublyNode curr = head;
        
        while (curr != null && newNode.val > curr.val) {  // find position to insert
            prev = curr;
            curr = curr.next;
        }
        
        if (prev == null) {  // insert at beginning. newNode.val <= head.val
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else if (curr == null) {  // insert at end
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        else {
            prev.next = newNode;
            curr.prev = newNode;
            newNode.prev = prev;
            newNode.next = curr;
        }
    }
    
    public void delete(int val) {    
        DoublyNode prev = null;
        DoublyNode curr = head;
        
        while (curr != null && curr.val != val) {  // find node with data
            prev = curr;
            curr = curr.next;
        }
        
        if (curr == null) {  // node with data is not found or list is empty
            return;
        }
        else if (prev == null) {  // node to delete is the first node
            head = curr.next;
            head.prev = null;
            if (curr == tail) {   // if delete results in empty list
                tail = null;
            }
        }
        else {
            prev.next = curr.next;
            if (curr.next != null) {
                curr.next.prev = prev;
            }
            if (curr == tail) {  // if deleted last item
                tail = prev;
            }
        }
    }
    
    public void display() {
        DoublyNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    
    public void displayReverse() {
        DoublyNode curr = tail;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.prev;
        }
        System.out.println();
    }
    
}
