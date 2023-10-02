package DSA.queue;

public class ListQueue<T> {
    
    private static class Node<T> {
        T item;
        Node<T> next;
        
        Node(T item) {
            this.item = item;
        }
    }
    
    private Node<T> front;
    private Node<T> rear;
    private int size = 0;
    
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        
        if (front == null) {
            front = newNode;
            rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    
    public T dequeue() {
        if (front == null) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        T item = front.item;
        front = front.next;
        return item;
    }
    
    public T peek() {
        if (front == null) {
            return null;
        }
        return front.item;
    }
    
    public int size() {
        return size;
    }
    
    public String toString() {
        String str = "";
        Node<T> curr = front;
        while (curr != null) {
            str += curr.item + " ";
            curr = curr.next;
        }
        return str;
    }
    
}
