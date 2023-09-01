package DSA.dataStructure;

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
    }
    
    public void display() {
        Node curr = head;  // use curr, not head. head is not to be updated.
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    
}
