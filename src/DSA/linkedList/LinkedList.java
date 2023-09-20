package DSA.linkedList;

public class LinkedList {

    public static void main(String[] args) {
        
        MyLinkedList ml = new MyLinkedList();
        
        for (int i = 0; i < 10; i++) {
            ml.append(i);
        }
        ml.display();
        ml.append(10);
        ml.display();
        
        MyLinkedList primes = new MyLinkedList();
        for (int i = 2; i <= 2000; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= i/2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.append(i);
            }
        }
        primes.display();
        
        ml.insert(-1);
        ml.display();
        ml.insert(11);
        ml.display();
        ml.insert(5);
        ml.display();
        
        System.out.println(ml.len());
        
        MyLinkedList ml2 = new MyLinkedList();
        ml2.insert(5);
        ml2.display();
        ml2.insert(2);
        ml2.display();
        ml2.insert(10);
        ml2.display();
        
        ml2.delete(1);
        ml2.display();
        ml2.delete(5);
        
        ml2.display();
        System.out.println("length: " + ml2.len());
        ml2.delete(2);
        ml2.display();
        System.out.println("length: " + ml2.len());
        ml2.delete(10);
        ml2.display();
        System.out.println("length: " + ml2.len());
        ml2.delete(6);
        ml2.display();
    }
}

class Node {
    int data;
    Node next;
    
    public Node() {
    }
    
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
            len++;
        }
    }
    
    public MyLinkedList(Node head) {
        this.head = head;
        Node curr = head;
        while (curr != null && curr.next != null) {  // find a tail to set
            curr = curr.next;
        }
        this.tail = curr;
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
    
    public void delete(int data) {
        Node prev = null;
        Node curr = head;
        
        while (curr != null && curr.data != data) {
            prev = curr;
            curr = curr.next;
        }
        
        if (curr == null) {  // node with data is not found or list is empty
            return;
        }
        else if (prev == null) {  // node with data is the first node
            head = curr.next;
            if (curr == tail) {   // if delete results in empty list
                tail = null;
            }
            len--;
        }
        else {
            prev.next = curr.next;
            if (curr == tail) {  // if deleted last item
                tail = prev;
            }
            len--;
        }
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
    
}
